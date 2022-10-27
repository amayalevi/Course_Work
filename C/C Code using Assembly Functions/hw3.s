//Levi Amaya ID#1001445809
//CSE 2312-002
//11/05/2020

.global isStrSame
.global strConcatenate
.global sumU16_32
.global sumS32
.global countInRange
.global rightStringFull
.global rightStringTrunc
.global sortAscending
.global decimalStringToUint16
.global decimalStringToInt8
.global hexStringToUint8
.global uint32ToBinaryString
.global findCityAligned
.global findCityPacked

text:

//a. bool isStrSame(const char str1[], const char str2[])
// returns 1 if the strings match, 0 otherwise
isStrSame:
PUSH {R4}
MOV R2,R0 	//R2 = &str1[0]
MOV R0, #1 	//by default, strings are assumed to be the same 
isStrSame_loop:
LDRSB R3,[R2]	//loading chars
LDRSB R4,[R1]
CMP R3,R4	//comparing array elements
BNE isStrSame_NE
CMP R3,#0	//cheking is chars are null
CMP R4,#0	
BEQ isStrSame_end //null terminators? go to end
ADD R2,R2,#1	//incrementing array pointers
ADD R1,R1,#1
B isStrSame_loop//loop back and check next chars
isStrSame_NE:
MOV R0,#0	//strings were not equal
isStrSame_end:
POP {R4}
BX LR

//b. void strConcatenate(char strTo[], const char strFrom[])
// adds the contents of string strFrom to strTo
// note: strTo must have enough space to hold strFrom and strTo
strConcatenate:
strConcatenate_check:
LDRSB R2,[R0]	//loading strTo[0] to R2
CMP R2,#0	//checking if char is null
BEQ strConcatenate_concat	//go to contatenation
ADD R0,R0,#1	//i++
B strConcatenate_check //continue check
strConcatenate_concat:
LDRSB R2,[R1]	//R2 = strFrom[0]
STRB R2,[R0]	//strTo[i] = R2
CMP R2,#0	//checking if char == null
BEQ strConcatenate_end	//go to end if true
ADD R0,R0,#1	//i++
ADD R1,R1,#1	//j++
B strConcatenate_concat //continue concat loop
strConcatenate_end:
BX LR

//c. uint32_t sumU16_32(const uint16_t x[], uint32_t count)
// returns sum of the values in the array (x) containing count entries.
sumU16_32:
MOV R2,R0	//R2 = R0 = &x[0]
MOV R0,#0	//sum = 0
sumU16_32_loop:
CMP R1,#0	//count == 0?
BEQ sumU16_32_end	//end program
LDRH R3,[R2]	//R3 = &x[i]
ADD R0,R0,R3	//sum += R3
ADD R2,R2,#2	//i++
SUB R1,R1,#1	//count--
B sumU16_32_loop//continue loop
sumU16_32_end:
BX LR

//d. int32_t sumS32(const int32_t x[], uint32_t count)
// returns sum of the values in the array (x) containing count entries.
sumS32:
MOV R2,R0	//R2 = R0 = &x[0]
MOV R0,#0	//sum = 0
sumS32_loop:
CMP R1,#0	//count == 0?
BEQ sumS32_end	//end program
LDR R3,[R2]	//R3 = &x[i]
ADD R0,R0,R3	//sum += R3
ADD R2,R2,#4	//i++
SUB R1,R1,#1	//count--
B sumS32_loop//continue loop
sumS32_end:
BX LR

//e. uint32_t countInRange(const int32_t x[], int32_t low, int32_t high, uint32_t count)
// returns number of values in the array (x) containing count entries that are >= low and <= high
countInRange:
PUSH {R4,R5}
MOV R4,R0	//R4 = R0 = &x[0]
MOV R0,#0	//values = 0
countInRange_loop:
CMP R3,#0	//count == 0?
BEQ countInRange_end	//end program
LDR R5,[R4]	//R5 = x[i]
CMP R5,R1	//R5 == low?
BLT countInRange_next
CMP R5,R2	//R5 == high?
BGT countInRange_next
ADD R0,R0,#1	//values++
countInRange_next:
ADD R4,R4,#4	//i++
SUB R3,R3,#1	//count--
B countInRange_loop//continue loop
countInRange_end:
POP {R4,R5}
BX LR

//f. void rightStringFull(char* strOut, const char* strIn, uint32_t length)
// input: array (strIn) containing the input string, and the number of characters to extract (length)
// output: array (strOut) containing length number of strIn characters from the
//end of the array or an empty string if the length is larger than can be accommodated
// strIn = ‘abcdef’, length = 5 → returns strOut = ‘bcdef’
// strIn = ‘abcdef’, length = 7 → returns strOut = ‘’
rightStringFull:
PUSH {R4}
//Find String length
MOV R3,#0	//string length = 0
rightStringFull_Strlength:
LDRSB R4,[R1]	//R4 = strIn[i]
CMP R4,#0	//R4 == 0?
BEQ rightStringFull_check //string length get
ADD R3,R3,#1	//strLength++
ADD R1,R1,#1	//strIn[i++]
B rightStringFull_Strlength//continue getting string length
rightStringFull_check:
CMP R3,R2	//Compare to strLength to "length"
BLT rightStringFull_tooLong
SUB R1,R1,R3	//i=0
//stringLength >= length ,continue
SUB R3,R3,R2	//strlength -= length
ADD R1,R1,R3	//&strIn[0+offset]
rightStringFull_loop:
LDRSB R4,[R1]	//R4 = strIn[R1]
STRB R4, [R0]	//strOut[j] = strIn[i]
ADD R0,R0,#1	//strOut[j++]
ADD R1,R1,#1	//strIn[i++]
CMP R4,#0	//R4 ==0?
BEQ rightStringFull_end//done
B rightStringFull_loop	//continue loop
rightStringFull_tooLong://length > string,return null
MOV R4,#0	//R4 = '\0'
STRB R4,[R0]	//strOut[0] = '\0'
rightStringFull_end:
POP {R4}
BX LR

//g. void rightStringTrunc(char* strOut, const char* strIn, uint32_t length)
// input: array (strIn) containing the input string, and the number of characters to extract (length)
// output: array (strOut) containing up to, but not exceeding length number of strIn characters from the end of the array
// strIn = ‘abcdef’, length = 5 → returns strOut = ‘bcdef’
// strIn = ‘abcdef’, length = 7 → returns strOut = ‘abcdef’
rightStringTrunc:
PUSH {R4}
//finding string length
MOV R4,#0	//strlength =0
rightStringTrunc_strLength:
LDRSB R3,[R1]	//R3 = strIn[i]
CMP R3, #0	//R3 == 0?
BEQ rightStringTrunc_next
ADD R1,R1,#1	//strIn[i++]
ADD R4,R4,#1	//strlength++
B rightStringTrunc_strLength //continue loop

rightStringTrunc_next:
SUB R1,R1,R4	//i=0
CMP R4,R2	//compare strLength to "length"
BEQ rightStringTrunc_loop
BLT rightStringTrunc_loop
//if string is greater than length
SUB R4,R4,R2	//strLength -= length
ADD R1,R1,R4	//R1 = &strIn[0+offset]

rightStringTrunc_loop:
LDRSB R3,[R1]	//R3 = strIn[i]
STRB R3,[R0]	//store to strOut[i]
CMP R3, #0	//R3 == 0?
BEQ rightStringTrunc_end//strIn[i] = 0
ADD R1,R1,#1	//strIn[i++]
ADD R0,R0,#1	//strOut[i++]
B rightStringTrunc_loop//continue loop
rightStringTrunc_end:
POP {R4}
BX LR

//h. void sortAscending(uint32_t x[], uint32_t count)
// input: array (x) containing count entries
// output: array (x), with the values sorted in ascending order
sortAscending:
//R0 = &x[]
//R1 = count
PUSH {R4,R5,R6,R7}
MOV R7,R0	//R7 = x[0]
MOV R6, R1	//R6 = count
sortAscending_start:
MOV R0,R7	//R0 = x[0]
MOV R2,R1	//R2 = count
CMP R6,#0	//outer loop check
BEQ sortAscending_end //done
SUB R6,R6,#1	//R6--

sortAscending_loop:
CMP R2,#1
BEQ sortAscending_start//one loop done
LDR R3,[R0]
LDR R4,[R0,#4]
CMP R3,R4
BGT swap
SUB R2,R2,#1
ADD R0,R0,#4
B sortAscending_loop//continue sort

swap:
STR R4, [R0]
STR R3, [R0,#4]
SUB R2,R2,#1
ADD R0,R0,#4
B sortAscending_loop//continue sort

sortAscending_end:
POP {R4,R5,R6,R7}
BX LR

//i. uint16_t decimalStringToUint16(const char* str)
// convert the null-terminated string (str) to an unsigned 16-bit integer
// treat the string as representing a decimal number
// if a character other than 0, 1, 2, 3, 4, 5, 6, 7, 8, or 9 is present or the value is too large, return 0
decimalStringToUint16:
PUSH {R4,R5,R6}
MOV R1,R0	//R1 = str[0]
MOV R0,#0	//x=0
MOV R3,#1	//R3 =1
MOV R4,#10	//Base 10
MOV R5,#0	//length = 0

decimalStringToUint16_length:
LDRSB R2,[R1]	//R2 = str[i]
CMP R2,#0	//R2 == '\0'?
BEQ decimalStringToUint16_next
ADD R5,R5,#1	//length++
ADD R1,R1,#1	//i++
B decimalStringToUint16_length

decimalStringToUint16_next:
CMP R5,#5	//size check
BGT failed	//too large, return 0
SUB R1,R1,#1	//last array value

decimalStringToUint16_loop:
CMP R5,#0	//length ==0?
BEQ decimalStringToUint16_end //done
LDRSB R2,[R1]	//R2 = str[i]
//cheking if R2 is a number
CMP R2,#0x30
BLT failed
CMP R2,#0x39
BGT failed
//R2 is a number
SUB R2,R2,#0x30
B decimalStringToUint16_continue

decimalStringToUint16_continue:
MUL R2,R3,R2	//
ADDS R0,R0,R2	//set flags
//checking overflow
AND R6,R0, #0x00010000
CMP R6,#0
BGT failed	//too large, return 0
MUL R3,R4,R3	//R3 *= 10
SUB R1,R1,#1	//i--
SUB R5,R5,#1	//length--
B decimalStringToUint16_loop

failed:
MOV R0,#0	//returning 0

decimalStringToUint16_end:
POP {R4,R5,R6}
BX LR

//j. int8_t decimalStringToInt8(const char* str)
// convert the null-terminated string (str) to a signed 8-bit integer
// treat the string as representing a decimal number
// if a character other than 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, or – is present or the value is out of range, return 0
decimalStringToInt8:
PUSH {R4,R5,R6}
MOV R1,R0	//R1 = str[0]
MOV R0,#0	//x=0
MOV R3,#1	//R3=1
MOV R4,#10	//Base 10
MOV R5,#0	//length = 0

decimalStringToInt8_length:
LDRSB R2,[R1]	//R2 = str[i]
CMP R2,#0	//R2 == '\0'?
BEQ decimalStringToInt8_next
ADD R5,R5,#1	//length++
ADD R1,R1,#1	//i++
B decimalStringToInt8_length

decimalStringToInt8_next:
CMP R5,#4	//size check
BGT decimalStringToInt8_failed	//too large, return 0
SUB R1,R1,#1	//last array value

decimalStringToInt8_loop:
CMP R5,#0	//length ==0?
BEQ decimalStringToInt8_end
LDRSB R2,[R1]	//R2 = str[i]
//cheking if negative
CMP R2,#0x2D
BEQ negate
//cheking if R2 is a number
CMP R2,#0x30
BLT decimalStringToInt8_failed
CMP R2,#0x39
BGT decimalStringToInt8_failed
//R2 is a number
SUB R2,R2,#0x30
B decimalStringToInt8_continue

negate:
MOV R6,#-1
MUL R0,R6,R0
CMP R0,#-128
BLT decimalStringToInt8_failed //too low, return 0
B decimalStringToInt8_end

decimalStringToInt8_continue:
MUL R2,R3,R2	//
ADD R0,R0,R2	//
MUL R3,R4,R3	//R3 *= 10
SUB R1,R1,#1	//i--
SUB R5,R5,#1	//length--
B decimalStringToInt8_loop

decimalStringToInt8_failed:
MOV R0,#0

decimalStringToInt8_end:
//checking overflow,//-128,127
CMP R0,#127
BGT decimalStringToInt8_failed	//too large, return 0
POP {R4,R5,R6}
BX LR

//k. uint8_t hexStringToUint8(const char* str)
// convert the null-terminated string (str) to an unsigned 8-bit integer
// treat the string as representing a hexadecimal number
// if a character other than 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, A, B, C, D, E, or F is present or the value is too large, return 0
hexStringToUint8:
PUSH {R4,R5,R6}
MOV R1,R0	//R1 = str[0]
MOV R0,#0	//x=0
MOV R3,#1	//R3=1
MOV R4,#16	//Base 16
MOV R5,#0	//length = 0

hexStringToUint8_length:
LDRSB R2,[R1]	//R2 = str[i]
CMP R2,#0	//R2 == '\0'?
BEQ hexStringToUint8_next
ADD R5,R5,#1	//length++
ADD R1,R1,#1	//i++
B hexStringToUint8_length

hexStringToUint8_next:
CMP R5,#2	//size check
BGT hexStringToUint8_failed	//too large, return 0
SUB R1,R1,#1	//last array value

hexStringToUint8_loop:
CMP R5,#0	//length ==0?
BEQ hexStringToUint8_end
LDRSB R2,[R1]	//R2 = str[i]
//cheking if R2 is a number
CMP R2,#0x30
BLT hexStringToUint8_failed
CMP R2,#0x39
BGT hexStringToUint8_letter
//R2 is a number
SUB R2,R2,#0x30
B hexStringToUint8_continue

hexStringToUint8_letter:
CMP R2,#0x41
BLT hexStringToUint8_failed//not a letter
CMP R2,#0x46
BGT hexStringToUint8_failed//not a letter
//R2 is a "letter"
SUB R2,R2,#55
B hexStringToUint8_continue

hexStringToUint8_continue:
MUL R2,R3,R2	//
ADD R0,R0,R2	//
MUL R3,R4,R3	//R3 *= 16
SUB R1,R1,#1	//i--
SUB R5,R5,#1	//length--
B hexStringToUint8_loop

hexStringToUint8_failed:
MOV R0,#0

hexStringToUint8_end:
//checking overflow,0-255
CMP R0,#255
BGT hexStringToUint8_failed//too large, return 0
POP {R4,R5,R6}
BX LR

//l. void uint32ToBinaryString(char* str, uint32_t x)
// convert the unsigned integer (x) to a null-terminated string (str) representing a binary number
uint32ToBinaryString:
PUSH {R4,R5}
MOV R2,#1
MOV R2,R2, ROR #1//mask
MOV R4,#0x30	//'0'
MOV R5,#32	//counter

uint32ToBinaryString_loop:
CMP R5,#0
BEQ uint32ToBinaryString_end//done
AND R3,R1,R2
CMP R3,#0
BNE uint32ToBinaryString_one
STRB R4,[R0]	//write 0
LSL R1,#1	//
SUB R5,R5,#1	//counter--
ADD R0,R0,#1	//i++
B uint32ToBinaryString_loop //continue loop

uint32ToBinaryString_one:
ADD R4,R4,#1
STRB R4,[R0]	//write 1
SUB R4,R4,#1	//'0'
LSL R1,#1	//
SUB R5,R5,#1	//counter--
ADD R0,R0,#1	//i++
B uint32ToBinaryString_loop //continue loop

uint32ToBinaryString_end:
MOV R4,#0
STRB R4,[R0]	//adding null terminator
POP {R4,R5}
BX LR

//m. int32_t findCityAligned(const char city[], const BUSINESS6 business[], uint32_t count)
// returns the index of the first entry in the array (business) containing count
//entries which matches the requested city. If the city is not found, return a value
//of -1. You can assume that C default alignment is used for this problem.
findCityAligned:

BX LR

//n. int32_t findCityPacked (const char city[], const BUSINESS6 business[], uint32_t count)
// returns the index of the first entry in the array (business) containing count
//entries which matches the requested city. If the city is not found, return a value
//of -1. You can assume that C packing is used for this problem.
findCityPacked:

BX LR

//Write the solution of each of these functions in a single file hw3.s with functions
//being callable from a C program. You do not need to send the .c file.


