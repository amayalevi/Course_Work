//Levi Amaya
//CSE 2312-002
//11/19/2020

.global prodF64
.global int32ToFloat
.global dotpF32
.global minF64

.text

//a. void prodF64(double z[], const double x[], const double y[], uint32_t count)
// compute the product of each element in the arrays x and y containing
// count entries; z[i] = x[i] * y[i], for i = 0, 1, … count-1
// If x = {10, 20, 30}, y = {5, 10, 5}, and count = 3, then z = {50, 200, 150}
prodF64:
CMP R3,#0
BLT prodF64_end //less than 0 is invalid
BEQ prodF64_end //0 elements --> end program
//count >0, continue

prodF64_loop:
CMP R3,#0	//cheking if count ==0
BEQ prodF64_end	//terminate program
VLDR D0,[R1]	//D0 = x[i]
VLDR D1,[R2]	//D1 = y[i]
VMUL.F64 D2,D0,D1	//D2 = D1*D2
VSTR D2,[R0]	//z[i] = D2
ADD R0,R0,#8	//R0++
ADD R1,R1,#8	//R1++ 
ADD R2,R2,#8	//R2++
SUB R3,R3,#1	//R3--
B prodF64_loop	//continue loop
prodF64_end:	//end program
BX LR

//b. float int32ToFloat(int32_t x)
// converts the signed integer to a single-precision floating point number
int32ToFloat:
VMOV S1, R0	//move x to S1
VCVT.F32.S32 S0,S1	// Convert,float <-- signed 32bit 
BX LR


//c. float dotpF32(const float x[], const float y[], uint32_t count)
// returns the dot product of two arrays (x and y) containing count entries
dotpF32:
MOV R3,#0
VMOV S0,R3	//Dot product = 0
CMP R2,#0
BLT dotpF32_end //less than 0 is invalid
BEQ dotpF32_end //0 elements --> end program
//count >0, continue

dotpF32_loop:
CMP R2,#0	//count == 0?
BEQ dotpF32_end	//end program
VLDR S1,[R0]	//S1 = x[i]
VLDR S2,[R1]	//S2 = y[i]
VMLA.F32 S0,S1,S2	//S0 = x[i]*y[i]
ADD R0,R0,#4	//x[i++]
ADD R1,R1,#4	//y[i++]
SUB R2,R2,#1	//count--
B dotpF32_loop	//continue loop

dotpF32_end:	//end program
BX LR

//d. double minF64(const double x[], uint32_t count)
// returns the minimum value in the array (x) containing count entries
// if x = {-1.1, 20, -3} and count = 3, then the function returns -3.
minF64:
VLDR D0,[R0]	//D0 = x[0]
CMP R1,#0
BEQ minF64_end

minF64_loop:
CMP R1,#0
BEQ minF64_end
ADD R0,R0,#8	//i++
VLDR D1, [R0]
VCMP.F64 D1,D0
VMRS APSR_nzcv, FPSCR //update ARM flags
VMOVLT.F64 D0,D1
SUB R1,R1,#1	//count--
B minF64_loop
minF64_end://end program
BX LR

