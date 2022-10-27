//Levi Amaya, ID#1001445809
//CSE 2441-001
//Homework #6, Problem #9
	module Problem9 (x,z,CLK,CLR);
	input x,CLK,CLR;
	output z;
	reg state;
	parameter A=1'b1,B=1'b0,C=1'b1,D=1'b0;
	always @(posedge CLK,negedge CLR)
		if(CLR ==0)
		state <=0;
		else
		case(state)
		A:if(~x)state <= A; else state <= B;
		B:if(~x)state <= C; else state <= B;
		C:if(~x)state <= D; else state <= B;
		D:if(~x)state <= A; else state <= B;
		endcase
	assign z = state;
endmodule