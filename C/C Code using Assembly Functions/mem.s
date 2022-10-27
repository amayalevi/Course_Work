.global writeU32
.global readU32
.global writeS32
.global readS32
.global writeU16
.global readU16
.global writeS16
.global readS16
.global writeU8
.global readU8
.global writeS8
.global readS8
.text

// void writeU32(uint32_t *p, uint32_t x)
// address in R0, value in R1
writeU32:
    STR R1, [R0]
    BX LR

// uint32_t readU32(uint32_t *p)
// address in R0, return value in R0
readU32:
    LDR R0, [R0]
    BX LR

// void writeS32(int32_t *p, int32_t x)
// address in R0, value in R1
writeS32:
    STR R1, [R0]
    BX LR

// int32_t readS32(int32_t *p)
// address in R0, return value in R0
readS32:
    LDR R0, [R0]
    BX LR

// void writeU16(uint16_t *p, uint16_t x)
// address in R0, value in R1
writeU16:
    STRH R1, [R0]
    BX LR

// uint16_t readU16(uint16_t *p)
// address in R0, return value in R0
readU16:
    LDRH R0, [R0]
    BX LR

// void writeS16(int16_t *p, int16_t x)
// address in R0, value in R1
writeS16:
    STRH R1, [R0]
    BX LR

// int16_t readS16(int16_t *p)
// address in R0, return value in R0
readS16:
    LDRSH R0, [R0]
    BX LR

// void writeU8(uint8_t *p, uint8_t x)
// address in R0, value in R1
writeU8:
    STRB R1, [R0]
    BX LR

// uint8_t readU8(uint8_t *p)
// address in R0, return value in R0
readU8:
    LDRB R0, [R0]
    BX LR

// void writeS8(int8_t *p, int8_t x)
// address in R0, value in R1
writeS8:
    STRB R1, [R0]
    BX LR

// int8_t readS8(int8_t *p)
// address in R0, return value in R0
readS8:
    LDRSB R0, [R0]
    BX LR
