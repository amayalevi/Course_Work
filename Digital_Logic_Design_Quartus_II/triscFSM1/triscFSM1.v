module triscFSM1(SysClock,StartStop,INC,CLR,JMP,LDA,STA,ADD,C0,C1,C2,C3,C4,C5,C7,C8,C9,C10,C11,C12,C13,C14);
	input SysClock,StartStop,INC,CLR,JMP,LDA,STA,ADD; 
	output reg C0,C1,C2,C3,C4,C5,C7,C8,C9,C10,C11,C12,C13,C14;
	reg[4:0] state,nextstate;
	parameter A=5'b00000,B=5'b00001,C=5'b00010,D=5'b00011,E=5'b00100,F=5'b00101,G=5'b00110,H=5'b00111,
				 I=5'b01000,J=5'b01001,K=5'b01010,L=5'b01011,M=5'b01100,N=5'b01101,O=5'b01110,P=5'b01111,
				 Q=5'b10000,R=5'b10001,S=5'b10010,T=5'b10011,U = 5'b10100;
		always @ (negedge SysClock,negedge StartStop)
			if(StartStop == 1'b0) state <=A; else state <= nextstate;
		always @ (state,INC,CLR,JMP,LDA,STA,ADD)
			case(state)																		// 01234578901234
				A:begin {C0,C1,C2,C3,C4,C5,C7,C8,C9,C10,C11,C12,C13,C14} = 14'b10000000000000; nextstate = B;end	//clear
				B:begin {C0,C1,C2,C3,C4,C5,C7,C8,C9,C10,C11,C12,C13,C14} = 14'b00010000000000; nextstate = C;end	//sel PC | C3=0 MDO, C3 = 1 PC , load PC
				C:begin {C0,C1,C2,C3,C4,C5,C7,C8,C9,C10,C11,C12,C13,C14} = 14'b00011000000000; nextstate = D;end	//mem load addr
				D:begin {C0,C1,C2,C3,C4,C5,C7,C8,C9,C10,C11,C12,C13,C14} = 14'b00011000000000; nextstate = E;end	//mem read addr data
				E:begin {C0,C1,C2,C3,C4,C5,C7,C8,C9,C10,C11,C12,C13,C14} = 14'b00100010000000;	//PC++ , IR <-- MDO[7:4]
					if(INC)nextstate = F;	//Increment ACC
						else if(CLR) nextstate = G;	//Clear ACC
							else if(JMP) nextstate = H;	// Jump to Address
								else if(LDA) nextstate = I;	//Load ACC
									else if(STA) nextstate  = M;	//Store ACC
										else	if (ADD) nextstate = P;end	//ACC  <-- ACC + MDO
				F:begin {C0,C1,C2,C3,C4,C5,C7,C8,C9,C10,C11,C12,C13,C14} = 14'b00000000100000; nextstate = B;end	//ACC++ ,goto B
				G:begin {C0,C1,C2,C3,C4,C5,C7,C8,C9,C10,C11,C12,C13,C14} = 14'b00000001000000; nextstate = B;end	//Clear ACC, goto B
				H:begin {C0,C1,C2,C3,C4,C5,C7,C8,C9,C10,C11,C12,C13,C14} = 14'b01000000000000; nextstate = B;end	// Load PC , goto B
				I:begin {C0,C1,C2,C3,C4,C5,C7,C8,C9,C10,C11,C12,C13,C14} = 14'b00000000000000; nextstate = J;end	// sel MDO | C3=0 MDO, C3 = 1 PC
				J:begin {C0,C1,C2,C3,C4,C5,C7,C8,C9,C10,C11,C12,C13,C14} = 14'b00001000000000; nextstate = K;end	//mem load addr
				K:begin {C0,C1,C2,C3,C4,C5,C7,C8,C9,C10,C11,C12,C13,C14} = 14'b00001000010000; nextstate = L;end	//mem read addr data
				L:begin {C0,C1,C2,C3,C4,C5,C7,C8,C9,C10,C11,C12,C13,C14} = 14'b00000000011000; nextstate = B;end	//Load ACC , go to B
				M:begin {C0,C1,C2,C3,C4,C5,C7,C8,C9,C10,C11,C12,C13,C14} = 14'b00001000000000; nextstate = N;end	//sel MDO | C3=0 MDO, C3 = 1 PC
				N:begin {C0,C1,C2,C3,C4,C5,C7,C8,C9,C10,C11,C12,C13,C14} = 14'b00001000000000; nextstate = O;end	//load address,
				O:begin {C0,C1,C2,C3,C4,C5,C7,C8,C9,C10,C11,C12,C13,C14} = 14'b00001100000000; nextstate = B;end	//write to address, goto B
				P:begin {C0,C1,C2,C3,C4,C5,C7,C8,C9,C10,C11,C12,C13,C14} = 14'b00000000000000; nextstate = Q;end	// sel MDO | C3=0 MDO, C3 = 1 PC
				Q:begin {C0,C1,C2,C3,C4,C5,C7,C8,C9,C10,C11,C12,C13,C14} = 14'b00001000000000; nextstate = R;end	// load addr
				R:begin {C0,C1,C2,C3,C4,C5,C7,C8,C9,C10,C11,C12,C13,C14} = 14'b00001000000000; nextstate = S;end	// read mem,C12,C13 = 00(ALU - ADD)
				S:begin {C0,C1,C2,C3,C4,C5,C7,C8,C9,C10,C11,C12,C13,C14} = 14'b00000000000001; nextstate = T;end	//Load ALU Buffer Reg
				T:begin {C0,C1,C2,C3,C4,C5,C7,C8,C9,C10,C11,C12,C13,C14} = 14'b00000000000000; nextstate = U;end	// C10 = 0, sel ALU
				U:begin {C0,C1,C2,C3,C4,C5,C7,C8,C9,C10,C11,C12,C13,C14} = 14'b00000000001000; nextstate = B;end	// Load ACC, goto B
				default:begin {C0,C1,C2,C3,C4,C5,C7,C8,C9,C10,C11,C12,C13,C14} = 14'b00000000000000; nextstate = A;end //Invalid op code
			endcase
endmodule