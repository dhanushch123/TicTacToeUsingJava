package codingNinjas_TicTacToe;

import java.util.Arrays;

public class Board {
	// board will have to take care of placing symbols
	// check invalid move s or p1,p2 wins
	private char board[][];
	private int boardsize = 3;
	private int count;
	private char player1Symbol,player2Symbol;
	public static final int PLAYER1WINS = 1;
	public static final int PLAYER2WINS = 2;
	public static final int INCOMPLETE = 3;
	public static final int DRAW = 4;
	public static final int INVALIDMOVE =5 ;
	public static final char EMPTY = ' ';
	
	public Board(char p1Symbol,char p2Symbol)
	{
		board = new char[boardsize][boardsize];
		for(char i[] : board)
		{
			Arrays.fill(i, EMPTY);
		}
		this.player1Symbol = p1Symbol;
		this.player2Symbol = p2Symbol;
		
	}
	
	public int setSymbol(char symbol,int x,int y) // this method is very crucial it checks the board and returns the current status or progress of the game
	{
		// 1. we have to check whether it is a valid position or not 
		// 2 . also we have to check it is occupied or not
		// 3. then check for if palyer 1 wins or player 2 wins;
		//4 . check vertical ,horizontal left diagonal and right diagonal
		//1 check position
		if(x<0 || x>= boardsize || y<0 || y>=boardsize || board[x][y] != EMPTY)
		{
			return INVALIDMOVE;
		}
		// place the symbol in board
		board[x][y] = symbol;
		count++;
		// check the board for player 1 wins or player 2 wins
		// check horizontally
		if(board[x][0] != EMPTY && board[x][0] == board[x][1] && board[x][1] == board[x][2])
		{
			return symbol==player1Symbol ? PLAYER1WINS:PLAYER2WINS;
		}
		// check vertically
		if(board[0][y] != EMPTY && board[0][y] == board[1][y] && board[1][y] == board[2][y])
		{
			return symbol==player1Symbol ? PLAYER1WINS:PLAYER2WINS;
		}
		// check if the element is part of left diagonal or right diagonal
		if(x==y && board[x][y] != EMPTY)
		{
			if(board[0][0] == board[1][1] && board[1][1] == board[2][2])
			{
				return symbol==player1Symbol ? PLAYER1WINS:PLAYER2WINS;
			}
		}
		// right diagonal
		if(x+y == boardsize-1 && board[0][2] != EMPTY)
		{
			if(board[0][2] == board[1][1] && board[1][1] == board[2][0])
			{
				return symbol==player1Symbol ? PLAYER1WINS:PLAYER2WINS;
			}
		}
		if(count == boardsize*boardsize)
		{
			return DRAW;
		}
		else
		{
			return INCOMPLETE;
		}
		
		
	}
	
	
	
	
	public void printBoard()
	{
		System.out.println("---------------");
		for(char i[] : board)
		{
			for(char j : i)
			{
				System.out.print("| " + j + " |");
			}
			System.out.println();
		}
		System.out.println("---------------");
	}
	
	
	
	
	

}

