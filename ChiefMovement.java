class ChiefMovement implements MovementType
{
	public boolean move(int sourceCoorX, int sourceCoorY, int destCoorX, int destCoorY, Coordinate[][] coordinate)
	{
		boolean moveFlag = true;

		if (destCoorX == sourceCoorX && destCoorY == sourceCoorY + 1)
		{		
			if (coordinate[destCoorX][destCoorY].getChessPiece() != null )
			{
				if (coordinate[sourceCoorX][sourceCoorY].getChessPiece().getColor().equals(coordinate[destCoorX][destCoorY].getChessPiece().getColor()))
				{
					return false;
				}
			}
		}
		
		else if (destCoorX == sourceCoorX && destCoorY == sourceCoorY - 1)
		{	
			if (coordinate[destCoorX][destCoorY].getChessPiece() != null )
			{
				if (coordinate[sourceCoorX][sourceCoorY].getChessPiece().getColor().equals(coordinate[destCoorX][destCoorY].getChessPiece().getColor()))
				{
					return false;
				}
			}
		}

		else if (destCoorX == sourceCoorX + 1 && destCoorY == sourceCoorY)
		{
			if (coordinate[destCoorX][destCoorY].getChessPiece() != null )
			{
				if (coordinate[sourceCoorX][sourceCoorY].getChessPiece().getColor().equals(coordinate[destCoorX][destCoorY].getChessPiece().getColor()))
				{
					return false;
				}
			}
		}
		
		else if (destCoorX == sourceCoorX - 1 && destCoorY == sourceCoorY)
		{
			if (coordinate[destCoorX][destCoorY].getChessPiece() != null )
			{
				if (coordinate[sourceCoorX][sourceCoorY].getChessPiece().getColor().equals(coordinate[destCoorX][destCoorY].getChessPiece().getColor()))
				{
					return false;
				}
			}
		}

		else if (destCoorX == sourceCoorX - 1 && destCoorY == sourceCoorY + 1)
		{	
			if (coordinate[destCoorX][destCoorY].getChessPiece() != null )
			{
				if (coordinate[sourceCoorX][sourceCoorY].getChessPiece().getColor().equals(coordinate[destCoorX][destCoorY].getChessPiece().getColor()))
				{
					return false;
				}
			}
		}

		else if (destCoorX == sourceCoorX + 1 && destCoorY == sourceCoorY + 1)
		{
			if (coordinate[destCoorX][destCoorY].getChessPiece() != null )
			{
				if (coordinate[sourceCoorX][sourceCoorY].getChessPiece().getColor().equals(coordinate[destCoorX][destCoorY].getChessPiece().getColor()))
				{
					return false;
				}
			}
		}

		
		else if (destCoorX == sourceCoorX + 1 && destCoorY == sourceCoorY - 1)
		{
			if (coordinate[destCoorX][destCoorY].getChessPiece() != null )
			{
				if (coordinate[sourceCoorX][sourceCoorY].getChessPiece().getColor().equals(coordinate[destCoorX][destCoorY].getChessPiece().getColor()))
				{
					return false;
				}
			}
		}

		
		else if (destCoorX == sourceCoorX - 1 && destCoorY == sourceCoorY - 1)
		{	
			if (coordinate[destCoorX][destCoorY].getChessPiece() != null )
			{
				if (coordinate[sourceCoorX][sourceCoorY].getChessPiece().getColor().equals(coordinate[destCoorX][destCoorY].getChessPiece().getColor()))
				{
					return false;
				}
			}
		}

		else
		{
			return false;
		}

		return moveFlag;
	}
}