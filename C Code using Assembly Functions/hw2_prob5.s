//Levi Amaya ID#1001445809
//CSE 2312-002
//10/01/2020

.global addU32_U64
.global addS64
.global convertS8ToS32
.global convertU16ToS32
.global maxS16
.global maxU32
.global isGreaterThanU16
.global isGreaterThanS16
.global shiftRightS32
.global shiftU16
.global isEqualU16

text:

//a. uint64_t addU32_U64(uint32_t x, uint32_t y) // returns x+y
//R0 = x
//R1 = y
//R1:R0
addU32_U64:
ADDS R0,R0,R1
MOV R1,#0
ADC R1,R1,#0
BX LR

//b. int64_t addS64(int64_t x, int64_t y) // returns x+y
//x = R1:R0
//y = R3:R2
addS64:
//MOV R4,R3
ADDS R0,R0,R2
ADC R1,R1,R3
BX LR

//c. int32_t convertS8ToS32(int8_t x) // converts 8-bit signed value to 32-bits signed
//x = R0
convertS8ToS32:
BX LR

//d. int32_t convertU16ToS32(uint16_t x) // converts 16-bit unsigned value to 32-bits signed
convertU16ToS32:
BX LR

//e. int16_t maxS16(int16_t x, int16_t y) // returns the maximum of x, y
//x = R0
//y = R1
maxS16:
CMP R0,R1
MOVLT R0,R1
BX LR

//f. uint32_t maxU32(uint32_t x, uint32_t y) // returns the maximum of x, y
maxU32:
CMP R0,R1
MOVLT R0,R1
BX LR

//g. bool isGreaterThanU16(uint16_t x, uint16_t y) // returns 1 if x>y, 0 else
isGreaterThanU16:
CMP R0,R1
MOV R0,#1
MOVEQ R0,#0
MOVLT R0,#0
BX LR

//h. bool isGreaterThanS16(int16_t x, int16_t y) // returns 1 if x>y, 0 else
isGreaterThanS16:
CMP R0,R1
MOV R0,#1
MOVEQ R0,#0
MOVLT R0,#0
BX LR

//i. int32_t shiftRightS32(int32_t x, uint8_t p) // returns x >> p = x*2^(-p) for p = 0..31
//x = R0
//p = R1
shiftRightS32:
MOV R0,R0, ASR R1
BX LR

//j. uint16_t shiftU16(uint16_t x, int8_t p) // return x*2^p for p = -31..31
//x = R0
//p = R1
shiftU16:
MOV R0, R0, LSL R1
BX LR

//k. bool isEqualU16(uint16_t x, uint16_t y) // returns 1 if x=y, 0 if x!=y
isEqualU16:
TEQ R0, R1
MOVEQ R0,#1
MOVNE R0,#0
BX LR
