public class Coordinate
{
	private Chess chessPiece;
	private int coordinateX;
	private int coordinateY;

	Coordinate(int coordinateX, int coordinateY, Chess chessPiece)
	{
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
		this.chessPiece = chessPiece;
	}

	Coordinate(int coordinateX, int coordinateY)
	{
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
	}

	public int getCoorX()
	{
		return coordinateX;
	}

	public int getCoorY()
	{
		return coordinateY;
	}

	public Chess getChessPiece()
	{
		return chessPiece;
	}

	public void setChessPiece(Chess chessPiece)
	{
		this.chessPiece = chessPiece;
	}
}