//Levi Amaya, ID#1001445809
//CSE 2441-001
//Homework #6, Problem #10
module Problem10(x,z,CLK,CLR);
input x,CLK,CLR;
output reg z;
reg [1:0]state,nextstate;
parameter S0 = 2'b00,S1 = 2'b01,S2 =2'b10, S3 = 2'b11;
always @ (posedge CLK,negedge CLR)
	if (CLR ==0)
	state <=S0;
	else
	state = nextstate;
always @ (state,x)
	case(state)
	S0:if(~x) nextstate = S3; else nextstate = S1;
	S1:if(~x) nextstate = S3; else nextstate = S2;
	S2:if(~x) nextstate = S3; else nextstate = S0;
	S3:if(~x) nextstate = S1; else nextstate = S2;
	endcase
always @ (state,x)
	case(state)
	S0:z =~x;
	S1:z =x;
	S2:z =x;
	S3:z =~x;	
	endcase
endmodule