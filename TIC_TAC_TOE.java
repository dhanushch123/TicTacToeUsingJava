package codingNinjas_TicTacToe;

import java.util.Scanner;



public class TIC_TAC_TOE {
	// tictactoe class should have Player class and board class
	// tictactoe class has take care of taking inputs and start game
	// 1. Take Input
	// one board
	// two players
	private Player player1,player2;
	private Board board;
	private int playerNumber;
	
	
	public static void main(String[] args)
	{
		TIC_TAC_TOE T = new TIC_TAC_TOE();
		T.startGame();
	}
	public void startGame()
	{
		Scanner sc = new Scanner(System.in);
		 player1 = takePlayerInput(++playerNumber);
		 player2 = takePlayerInput(++playerNumber);
		while(player2.getSymbol()==player1.getSymbol())
		{
			System.out.println("Symbol has already taken!! Select an Unique symbol !!");
			player2.setSymbol(sc.next().charAt(0));
		}
		board = new Board(player1.getSymbol(),player2.getSymbol());
		// the players input has completed and the game has to start
		boolean player1Turn = true;
		int status = Board.INCOMPLETE;
		while(status == Board.INCOMPLETE || status == Board.INVALIDMOVE) // the loop should continue till the board is incomplete or if invalid move it should try again
		{
			if(player1Turn)
			{
				System.out.println(player1.getName()+" 's Turn Choose the position");
				System.out.println("Enter x[row] : ");
				int x = sc.nextInt();
				System.out.println("Enter y[column] : ");
				int y = sc.nextInt();
				status = board.setSymbol(player1.getSymbol(), x, y);
			}
			else
			{
				System.out.println(player2.getName()+" 's Turn Choose the position");
				System.out.println("Enter x[row] : ");
				int x = sc.nextInt();
				System.out.println("Enter y[column] : ");
				int y = sc.nextInt();
				status = board.setSymbol(player2.getSymbol(), x, y);
			}
			if(status == Board.INVALIDMOVE)
			{
				System.out.println("Sorry!! Enter the correct position");
			}
			else
			{
				player1Turn = !player1Turn;
				board.printBoard();
			}
		}
		switch(status)
		{
		case Board.PLAYER1WINS:
			board.printBoard();
			System.out.println("Hurray !! " + player1.getName() + " won");
			
			break;
		case Board.PLAYER2WINS:
			board.printBoard();
			System.out.println("Hurray !! " + player2.getName() + " won");
			
			break;
		case Board.DRAW:
			System.out.println("DRAW !!");
			break;
		
		}
		
	}
	public Player takePlayerInput(int PlayerNumber)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Player " + PlayerNumber+" 's name : ");
		String name = sc.next();
		System.out.println("Enter Player " + PlayerNumber+" 's symbol : ");
		char symbol = sc.next().charAt(0);
		
		
		return new Player(name,symbol);
	}
	

}

