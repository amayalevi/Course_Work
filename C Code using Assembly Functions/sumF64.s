.global sumF64 

.text

// double sumF64(const double x[], uint32_t count)
// address of x[0] is R0, count in R1 -> return sum in D0
sumF64:
    MOV R2, #0          // R2 = 0
    VMOV D0, R2, R2     // zero our sum in D0 (D0 <= R2:R2)
sumF64_loop:
    CMP R1, #0          // is count zero?
    BEQ sumF64_end      // yes, exit fn
    VLDR D1, [R0]       // no, load D1 with next value in array (D1 <= *R0)
    ADD R0, R0, #8      // inc R0 by sizeof(double) = 8
    VADD.F64 D0, D0, D1 // D0 <= D0 + D1 (running sum)
                        // .F64 means D0 and D1 contain double, not uint64_t or int64_t
    SUB R1, R1, #1      // decrement count
    B sumF64_loop       // get next value
sumF64_end:
    BX LR
