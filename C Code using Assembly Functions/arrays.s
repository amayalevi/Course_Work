.global scaleU32
.global dotpU32

.text

// scaleU32(uint32_t y[], const uint32_t x[], uint32_t scale, uint32_t count)
// add of y[0] in R0, add of x[0] in R1, scale in R2, count in R3
scaleU32:
    PUSH {R4, R5}    // push R5, then R4 onto stack
scaleU32_loop:
    CMP R3, #0       // is count = 0?
    BEQ scaleU32_end // yes -> exit
    LDR R4, [R1], #4 // R4 = *R1, R1 = R1 + sizeof(uint32_t) 
    MUL R5, R4, R2   // R5 = R4 * R2 
                     // (multiply has had issues in past, use diff registers for src and target)
    STR R5, [R0], #4 // *R0 = R5, R0 = R0 + sizeof(uint32_t)
    SUB R3, R3, #1   // dec count
    B scaleU32_loop
scaleU32_end:
    POP {R4, R5}     // pop R4, then R5 from stack
    BX LR

// uint32_t dotpU32(uint32_t x[], const uint32_t y[], uint32_t count)
// add of x[0] in R0, add of y[0] in R1, count in R2 -> return prod in R0
dotpU32:
    PUSH {R4, R5}
    MOV R3, R0         // R3 = &x[0]
    MOV R0, #0         // R0 = prod = 0
dotpU32_loop:
    CMP R2, #0         // is count = 0?
    BEQ dotpU32_end
    LDR R4, [R3], #4   // R4 = *R3, R3 = R3 + sizeof(uint32_t) // x[]
    LDR R5, [R1], #4   // R5 = *R1, R1 = R1 + sizeof(uint32_t) // y[]
    MLA R0, R4, R5, R0 // R0 = R4*R5 + R0 (multiple and accumulate in R0
    SUB R2, R2, #1 // dec count
    B dotpU32_loop
dotpU32_end:
    POP {R4, R5}
    BX LR
