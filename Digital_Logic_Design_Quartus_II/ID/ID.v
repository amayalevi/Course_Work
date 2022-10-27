module ID(IR3,IR2,IR1,IR0,LDA,STA,ADD,SUB,XOR,INC,CLR,JMP,JPZ,JPN,HLT);
input IR3,IR2,IR1,IR0;
output reg LDA,STA,ADD,SUB,XOR,INC,CLR,JMP,JPZ,JPN,HLT;
	always @(IR3,IR2,IR1,IR0) begin
	case({IR3,IR2,IR1,IR0})
		4'b0000:begin {LDA,STA,ADD,SUB,XOR,INC,CLR,JMP,JPZ,JPN,HLT} = 11'b10000000000;end//LDA
		4'b0001:begin {LDA,STA,ADD,SUB,XOR,INC,CLR,JMP,JPZ,JPN,HLT} = 11'b01000000000;end//STA
		4'b0010:begin {LDA,STA,ADD,SUB,XOR,INC,CLR,JMP,JPZ,JPN,HLT} = 11'b00100000000;end//ADD
		4'b0011:begin {LDA,STA,ADD,SUB,XOR,INC,CLR,JMP,JPZ,JPN,HLT} = 11'b00010000000;end//SUB
		4'b0100:begin {LDA,STA,ADD,SUB,XOR,INC,CLR,JMP,JPZ,JPN,HLT} = 11'b00001000000;end//XOR
		4'b0110:begin {LDA,STA,ADD,SUB,XOR,INC,CLR,JMP,JPZ,JPN,HLT} = 11'b00000100000;end//INC
		4'b0111:begin {LDA,STA,ADD,SUB,XOR,INC,CLR,JMP,JPZ,JPN,HLT} = 11'b00000010000;end//CLR
		4'b1000:begin {LDA,STA,ADD,SUB,XOR,INC,CLR,JMP,JPZ,JPN,HLT} = 11'b00000001000;end//JMP
		4'b1100:begin {LDA,STA,ADD,SUB,XOR,INC,CLR,JMP,JPZ,JPN,HLT} = 11'b00000000100;end//JPZ
		4'b1001:begin {LDA,STA,ADD,SUB,XOR,INC,CLR,JMP,JPZ,JPN,HLT} = 11'b00000000010;end//JPN
		4'b1111:begin {LDA,STA,ADD,SUB,XOR,INC,CLR,JMP,JPZ,JPN,HLT} = 11'b00000000001;end//HLT
		default:begin {LDA,STA,ADD,SUB,XOR,INC,CLR,JMP,JPZ,JPN,HLT} = 11'b00000000000;end //unused OP code
	endcase
	end
endmodule