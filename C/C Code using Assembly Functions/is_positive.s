.global isPositiveU32
.global isPositiveS32

.text

/*
// bool isPositiveU32(uint32_t x)
// R0 = x, return 1 in R0 if positive, 0 in R0 else
isPositiveU32:
    CMP R0, #0 // z=1, zero, z0, positive
    MOVNE R0, #1 // positive
    MOVEQ R0, #0 // zero
    BX LR

*/

// bool isPositiveU32(uint32_t x)
// R0 = x, return 1 in R0 if positive, 0 in R0 else
isPositiveU32:
    CMP R0, #0 // z=1, zero, z0, positive
    MOV R0, #1 // assume positive
    MOVEQ R0, #0 // zero
    BX LR

// bool isPositiveS32(int32_t x)
// R0 = x, return 1 in R0 if positive, 0 in R0 else
isPositiveS32:
    CMP R0, #0 // z=1, zero, z=0, not zero, s=1, negative, s=0, not neg
    MOV R0, #1 // assume positive
    MOVEQ R0, #0 // zero
    MOVMI R0, #0 // negative
    BX LR

