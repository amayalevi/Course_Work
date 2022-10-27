.global sumU32 

.text

// uint32_t sumU32(const uint32_t x[], uint32_t count)
// address of x[0] is R0, count in R1 -> return sum in R0
sumU32:
    MOV R2, R0       // R2 is address of x[0]
    MOV R0, #0       // zero our sum
sumU32_loop:
    CMP R1, #0       // is count zero?
    BEQ sumU32_end   // yes, exit fn
    LDR R3, [R2], #4 // no, load R3 with next value in array
                     // R3 = *R2, R2+= sizeof(uint32_t) -> x[i++]
    ADD R0, R0, R3   // R0 = R0 + R3
    SUB R1, R1, #1   // decrement count
    B sumU32_loop    // get next value
sumU32_end:
    BX LR
