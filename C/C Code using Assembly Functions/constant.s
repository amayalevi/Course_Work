.global getConstantU32
.global getConstantS32

.text

// uint32_t getConstantU32()
// return result in R0
getConstantU32:
/*
    MOV R0, #1      // 00000001 ROR 0 -> N = 0x01, S = 0
    MOV R0, #0xC7   // 11000111 ROR 0 -> N = 0xC7, S = 0
    MOV R0, #0xC700 // 1100011100000000 ROR 8 -> N = 0xC7, S = 4
    MOV R0, #0x1FE  // 111111110 -> no encoding possible
    MOV R0, #0x101  // 111111111 -> no encoding possible
    MOV R0, #0x3FC  // 1111111100 ROR 2 -> N = 0xFF, S = 1
*/
    MOV R0, #0x7000000C // 01110000000000000000000000001100 ROR 28 
                        // -> N = 0xC7, S = 14
    BX LR

// int32_t getConstantS32()
// return result in R0
getConstantS32:
/*
    MOV R0, #1      // 00000001 ROR 0 -> N = 0x01, S = 0
    MVN R0, #0      // 00000000 ROR 0 -> N = 0x00, S = 0 -> -1
*/
    MOV R0, #-1     // assembler converts to MVN R0, #0
    BX LR

 
