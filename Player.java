package codingNinjas_TicTacToe;

public class Player {
	// we have to create a player class that should contain name and symbol
	private String name;
	private char symbol;
	public Player(String name,char symbol)
	{
		// as they are private we cannot assign directly
		// we use getters and setters
		setName(name);
		setSymbol(symbol);
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setSymbol(char symbol)
	{
		if(symbol != '\0')
		{
			this.symbol = symbol;
		}
	}
	public String getName()
	{
		return this.name;
	}
	public char getSymbol()
	{
		return this.symbol;
	}

}
