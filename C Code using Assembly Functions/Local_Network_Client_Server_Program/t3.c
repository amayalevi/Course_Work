// Tic-tac-toe (T3) Network Game
// Jason Losh

//-----------------------------------------------------------------------------
// Compile notes for C99 code
//-----------------------------------------------------------------------------

// gcc -o t3 t3.c udp.c

//-----------------------------------------------------------------------------
// Device includes, defines, and assembler directives
//-----------------------------------------------------------------------------

#include <stdlib.h>          // EXIT_ codes
#include <stdbool.h>         // bool
#include <stdio.h>           // printf, scanf
#include <string.h>          // strlen, strcmp

#include "udp.h"

#define CLIENT_PORT 4096
#define SERVER_PORT 4097

void clearBoard(char board[3][3])
{
    for (int r = 0; r < 3; r++)
        for (int c = 0; c < 3; c++)
            board[r][c] = '.';
}

//  Add code to display the game board
void showBoard(char board[3][3])
{
for (int r = 0; r < 3; r++)
        for (int c = 0; c < 3; c++){
		printf("%c ",board[r][c]);
		if(c == 2)
			printf("\n");		
		}
}

//  Add code to determine if a winner (xo) has occurred
bool isWinner(char board[3][3], char xo)
{
	bool win = false;
	for (int r = 0; r < 3; r++)
		if(board[r][0] == xo && board[r][1] == xo && board[r][2] ==xo)
			win = true;//row r has all three char xo
	for (int c = 0; c < 3; c++)
		if(board[0][c] ==xo && board[1][c] ==xo && board[2][c] ==xo)
			win = true;//col c has all three char xo
	if(board[0][0] == xo && board[1][1] == xo && board[2][2] == xo)
		win = true;//1st diagonal has all three char xo
	if(board[2][0] == xo && board[1][1] == xo && board[0][2] == xo)
		win = true;//2nd diagonal has all three char xo
	return win;
}

//  Add code to test if an x or o (xo) is a valid move
//       and then record in the game board
bool addMove(char board[3][3], char move[], char xo)
{
//[r][c]
	bool ok = true;
	if(strlen(move) == 2){//2chars + \n
			if(move[0] == 'A' || move[0] == 'B' ||move[0] == 'C' ){//valid 1st char
				
				if(move[1] == '1' || move[1] == '2' ||move[1] == '3'){//valid 2nd char
					
					if(board[((int)move[0])-65][((int)move[1])-49] == '.'){//legal move
						board[((int)move[0])-65][((int)move[1])-49] = xo;//play move
						}
					else
						ok = false;//illegal move
					}
				else
					ok = false;//illegal move
				}
			else
				ok = false;//illegal move
			}
	else
		ok = false;//illegal move
	return ok;//move made
}

//-----------------------------------------------------------------------------
// Main
//-----------------------------------------------------------------------------

int main(int argc, char* argv[])
{
    char *remoteIp;
    char *role;
    char str[100], str2[100];
    char board[3][3];
    bool validMove;
    bool winner = false;
    int moveCount = 0;

    bool myTurn;
    char myLetter, opponentLetter;
    int remotePort;

    //Verify arguments are valid
     bool goodArguments;
	if(argc == 3)
		goodArguments = true;
	else
		goodArguments = false;

	// Once the arg count is verified:
	//- the IP address should be stored
	remoteIp = argv[1];
	//- The last argument is verified as “accept” or “invite”
	if(!strcmp(argv[2],"accept") || !strcmp(argv[2],"invite"))
		goodArguments = true;
	else
		goodArguments = false;

	if (!goodArguments)
	    {
		printf("usage: t3 IPV4_ADDRESS ROLE\n");
		printf("  where:\n");
		printf("  IPV4_ADDRESS is address of the remote machine\n");
		printf("  ROLE is either invite or accept\n");
		exit(EXIT_FAILURE);
	    }		
//- The role (server or client respectively) is stored
role = argv[2];
bool client;
    // Determine if client or server
    // bool client = _____;
	if(!strcmp(role,"accept"))
		client = false;//server
	else
		client = true;//client
	// Determine remote port that you will send data to    
	if(client)
		remotePort = 4096;//client port
	else
		remotePort = 4097;//server port
    // Open listener port number dependent on client/server role
	if(openListenerPort(remoteIp,remotePort))
		printf("Opening listener port: SUCCESS\n");
	else{
		printf("ERROR: Unable to open listener port.\n");
		return -1;
		}

	// A server will wait to accept an invitation to play
	// A client will send an invitation to play
	// If you are server, send to client port, and vice versa
	if(!client){//server
		printf("Waiting for client...\n");
		receiveData(str,sizeof(str));//waiting for client
		if(!strcmp(str,"invite"))
			printf("Client invitation recieved!\n");
		else{
			printf("ERROR: Client message was not an invitation.\n");
			return -1;
			}
		}
	else{	//client
		printf("Sending invitation to server...\n");
		if(sendData(remoteIp,4097,"invite"))
			printf("Invitation sent!\n");
		else	
			printf("ERROR: Invitation not sent.\n");
		}

    // Setup game
    clearBoard(board);

    // Determine whether it is your turn or not
    // myTurn = ______;
    // Determine your letter (x or o) and your opponent's letter
	if(client){//client waits on server
		myTurn = false;
		myLetter = 'o';
		opponentLetter = 'x';
		}
	else{	//server has 1st move
		myTurn = true;
		myLetter = 'x';
		opponentLetter = 'o';
		}
	
    // Add code to send an invite or wait to accept an invite

    // Start game loop, alternating turns
    while(!winner && moveCount != 9)
    {
        // get my move
        if (myTurn)
        {
            //  add code your move here to get the move, validate move,
		printf("Enter your move (%c): ",myLetter);
		fgets(str2,sizeof(str2),stdin);//get input
		str2[strcspn(str2,"\n")] = 0;

		while(!addMove(board,str2,myLetter))//sending move
			{//while move is invalid
				printf("Move was invalid/illegal. Enter your move (%c): ",myLetter);
				fgets(str2,sizeof(str2),stdin);//get input
				str2[strcspn(str2,"\n")] = 0;
			}
            //       show board, send move to remote port, and check for a winner
		showBoard(board);
		if(client){
			if(!sendData(remoteIp,4097,str2))
				printf("ERROR. Move was not sent.");
			}
		else{
			if(!sendData(remoteIp,4096,str2))
				printf("ERROR. Move was not sent.");
			}
			
		winner = isWinner(board,myLetter);
		
        }
        // get opponent's move
        else
        {
            //  add code to receive your opponent's move, validate move,

		receiveData(str2,sizeof(str2));
		if(!addMove(board,str2,opponentLetter))
			{
			printf("Illegal Move: Exiting game");
			return -1;
			}
            //  show board, and check for a winner
		printf("Your opponent (%c) moved to: %s\n",opponentLetter,str2);
		showBoard(board);
		winner = isWinner(board,opponentLetter);
        }

        // Increment move count, alternate turns
        moveCount++;
	if(winner && myTurn)
		printf("You (%c) won!\n",myLetter);
	if(winner && !myTurn)
		printf("Your opponent (%c) won!\n",opponentLetter);
        myTurn = !myTurn;
    }
	if (!winner)
        printf("The game was a draw\n");

    // Close listener port
	closeListenerPort();
    return EXIT_SUCCESS;
}

















