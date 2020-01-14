class AdvancerForwardMovement implements MovementType
{
	public boolean move(int sourceCoorX, int sourceCoorY, int destCoorX, int destCoorY, Coordinate[][] coordinate)
	{
		boolean moveFlag = true;

		if (destCoorX == sourceCoorX && destCoorY == sourceCoorY + 1)
		{
			if (coordinate[destCoorX][destCoorY].getChessPiece() != null)
			{	
				if (coordinate[sourceCoorX][sourceCoorY].getChessPiece().getColor().equals(coordinate[destCoorX][destCoorY].getChessPiece().getColor()))
				{
					return false;
				}
			}
		}

		else if (destCoorX == sourceCoorX && destCoorY == sourceCoorY + 2)
		{
			if (coordinate[sourceCoorX][sourceCoorY + 1].getChessPiece() == null)
			{	
				if (coordinate[sourceCoorX][sourceCoorY + 2].getChessPiece() != null)
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
		}
		
		
		else
		{
			return false;
		}

		return moveFlag;
	}
}