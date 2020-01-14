import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

public class Advancer extends Chess
{
	private BufferedImage forwardPieceImage;
	private BufferedImage backwardPieceImage;
	private MovementType movementType;

	Advancer(String pieceColor, boolean flippedState)
	{
		super(pieceColor,flippedState);

		setIcon();

		movementType = new AdvancerForwardMovement();
	}

	Advancer(String pieceColor, boolean flippedState, String movementType)
	{
		super(pieceColor,flippedState);

		setIcon();

		if (movementType.equals("ForwardMovement"))
		{
			this.movementType = new AdvancerForwardMovement();
		}
		else
		{
			this.movementType = new AdvancerBackwardMovement();
		}
	}

	public BufferedImage getIcon()
	{
		if (getFlippedState() == true)
		{
			return backwardPieceImage;
		}
		else
		{
			return forwardPieceImage;	
		}
	}

	public MovementType getMovementType()
	{

		return movementType;
	}

	public void swapMovementType()
	{
		if (movementType instanceof AdvancerForwardMovement)
		{
			movementType = new AdvancerBackwardMovement();	
		} 
		else
		{
			movementType = new AdvancerForwardMovement();
		}
	}

	public void setIcon()
	{
		try
		{	
			File forwardPieceImageFile;
			File backwardPieceImageFile;
			int width = 20;
			int height = 20;

			if (getColor().equals("Green"))
			{
				forwardPieceImageFile = new File("src/piece_img/advancer_forward_green.png");
				backwardPieceImageFile = new File("src/piece_img/advancer_backward_green.png");
			}
			else 
			{
				forwardPieceImageFile = new File("src/piece_img/advancer_forward_orange.png");
				backwardPieceImageFile = new File("src/piece_img/advancer_backward_orange.png");
			}

			forwardPieceImage = new BufferedImage(width,height, BufferedImage.TYPE_INT_ARGB);
			forwardPieceImage = ImageIO.read(forwardPieceImageFile);
			backwardPieceImage = new BufferedImage(width,height, BufferedImage.TYPE_INT_ARGB);
			backwardPieceImage = ImageIO.read(backwardPieceImageFile);
		}

		catch(IOException e)
		{
			System.out.println("Error: "+e);
		}
	}

	public boolean isMovable(int sourceCoorX, int sourceCoorY, int destCoorX, int destCoorY, Coordinate[][] coordinate)
	{
		return movementType.move(sourceCoorX, sourceCoorY, destCoorX, destCoorY, coordinate);
	}

	public String toString() 
	{
		return "Advancer";
	}

	public String movementTypeToString() 
	{
		if (movementType instanceof AdvancerForwardMovement)
		{
			return "ForwardMovement";	
		}

		else
		{
			return "BackwardMovement";
		}
	}
}
	