import javax.swing.*;  

public class ChessTiles extends JLabel
{
	private int coordinateX;
	private int coordinateY;

	ChessTiles(int coordinateX, int coordinateY)
	{
		this.coordinateX =  coordinateX;
		this.coordinateY =  coordinateY;
	}

	public int getCoorX()
	{
		return coordinateX;
	}

	public int getCoorY()
	{
		return coordinateY;
	}

}