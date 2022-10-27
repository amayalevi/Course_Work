.global strLength 
.global strFind 
.global strFindN 

.text

// uint32_t strLength(const char str[])
// address of str[0] in R0, return length in R0
strLength:
    MOV R1, R0 // R1 = &str[0]
    MOV R0, #0 // R0 = i = 0
strLength_loop:
    LDRSB R2, [R1, R0] // R2 = str[R0] = str[i]
    CMP R2, #0         // is null character?
    BEQ strLength_end  // yes, exit fn
    ADD R0, R0, #1     // i++
    B strLength_loop   // look at next character
strLength_end:
    BX LR

// int32_t strFind(const char str[], char c)
// address of str[0] in R0, character to find in R1
// return index in str of first instance of c, -1 is not found in R0
strFind:
    MOV R2, R0         // R2 = &str[0]
    MOV R0, #0         // R0 = i = 0
strFind_loop:
    LDRSB R3, [R2, R0] // R3 = str[i] 
    CMP R3, R1         // is str[i] = c?
    BEQ strFind_end    // yes
    ADD R0, R0, #1     // i++
    CMP R3, #0         // is str[i] = '\0'?
    BNE strFind_loop   // no -- look at next character
    MOV R0, #-1        // yes, return -1 (not found)
strFind_end:
    BX LR

// int32_t strFindN(const char str[], char c, uint32_t n)
// address of str[0] in R0, character to find in R1, instance in R2
// return index in str of nth instance of c, -1 is not found in R0
// Rule from ARM:
// A called function can only alter R0-3, R12
// If a called function needs to use R4-11, 13-15 it must preserve value
strFindN:
    PUSH {R4}          // save R4 on stack
    MOV R3, R0         // R3 = &str[0]
    MOV R0, #0         // R0 = i = 0
strFindN_loop:
    LDRSB R4, [R3], #1 // R4 = str[i] 
    CMP R4, R1         // is str[i] = c?
    BNE strFindN_next   // no
    SUBS R2, R2, #1    // n--
    BEQ strFindN_end    // found nth instance
strFindN_next:
    ADD R0, R0, #1     // increment offset
    CMP R4, #0         // is str[i] = '\0'?
    BNE strFindN_loop   // check next character
    MOV R0, #-1        // no found, return -1
strFindN_end:
    POP {R4}           // restores R4 from stack
    BX LR

    