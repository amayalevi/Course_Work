.global strLength 

.text

/*
// uint32_t strLength(const char str[])
// address of str[0] in R0, return length in R0
strLength:
    MOV R1, R0 // R1 = &str[0]
    MOV R0, #0 // R0 = count = 0
strLength_loop:
    LDRSB R2, [R1]     // R2 = *R1
    ADD R1, R1, #1     // R1 = R1 + 1
    CMP R2, #0         // is null character?
    BEQ strLength_end  // yes, exit fn
    ADD R0, R0, #1     // count++
    B strLength_loop   // look at next character
strLength_end:
    BX LR

// uint32_t strLength(const char str[])
// address of str[0] in R0, return length in R0
strLength:
    MOV R1, R0 // R1 = &str[0]
    MOV R0, #0 // R0 = count = 0
strLength_loop:
    LDRSB R2, [R1], #1 // R2 = *(R1++) -> R2 = *R1, R1+=1
    CMP R2, #0         // is null character?
    BEQ strLength_end  // yes, exit fn
    ADD R0, R0, #1     // count++
    B strLength_loop   // look at next character
strLength_end:
    BX LR

*/

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

