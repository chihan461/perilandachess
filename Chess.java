import java.awt.image.BufferedImage;

abstract public class Chess 
{
	private String pieceColor;
	
	private boolean flippedState;

	Chess(String pieceColor, boolean flippedState)
	{
		this.pieceColor = pieceColor;
		this.flippedState = flippedState;
	}

	public String getColor()
	{
		return pieceColor;
	}

	public boolean getFlippedState()
	{
		return flippedState;
	}

	public void flipState()
	{
		flippedState = !flippedState;
	}

	abstract public BufferedImage getIcon();

	abstract public MovementType getMovementType();
	
	abstract public void swapMovementType();

	abstract public void setIcon();

	abstract public boolean isMovable(int sourceCoorX, int sourceCoorY, int destCoorX, int destCoorY, Coordinate[][] coordinate);

	abstract public String toString();

	abstract public String movementTypeToString();
}

