import javax.swing.*;  
import java.io.File;  
import java.awt.event.*;
import javax.swing.TransferHandler;
import java.awt.datatransfer.*;

public class Controller {

	private Game game;
	private PlayingFrame playingFrame;
	private MainFrame mainFrame;
	
	MouseListener dndListener = new MouseAdapter()
	{
	    @Override
	    public void mousePressed(MouseEvent e)
	    {
	    	ChessTiles c = (ChessTiles) e.getSource();
	        TransferHandler dndHandler = c.getTransferHandler();
	        dndHandler.exportAsDrag(c, e, TransferHandler.MOVE);
	    }
	};
		
	MouseListener startGameListener = new MouseAdapter()
	{
		@Override
		public void mousePressed(MouseEvent e)
		{
			game = new Game();
			playingFrame.clearGraveyardIcon();
			setChessPieceIcon();
            setPlayerMoveCount();
            setPlayerToMove();

			playingFrame.setVisible(true);
			mainFrame.setVisible(false);
		}
	};

	MouseListener loadGameListener = new MouseAdapter()
	{
		@Override
		public void mousePressed(MouseEvent e)
		{
			String fileDir;
			JFileChooser file = new JFileChooser();
			file.setCurrentDirectory(new File(System.getProperty("user.home") + "/Desktop"));
			int result = file.showOpenDialog(null);

			if (result == JFileChooser.APPROVE_OPTION) 
			{
				fileDir = (("" + file.getCurrentDirectory().toString()) + "\\" + file.getSelectedFile().getName());
				game = new Game(new File(fileDir));
				setChessPieceIcon();
	            setPlayerMoveCount();
	            setPlayerToMove();
	            setGraveyardIcon();

				playingFrame.setVisible(true);
				mainFrame.setVisible(false);

			}
		}
	};
	
	MouseListener backToMenuListener = new MouseAdapter()
	{
		@Override
		public void mousePressed(MouseEvent e)
		{
			playingFrame.setVisible(false);
			mainFrame.setVisible(true);
			game = null;
		}
	};
	
	MouseListener saveGameListener = new MouseAdapter()
	{
		@Override
		public void mousePressed(MouseEvent e)
		{
			String fileDir;
			JFileChooser file = new JFileChooser();
			file.setCurrentDirectory(new File(System.getProperty("user.home") + "/Desktop"));
			int result = file.showSaveDialog(null);

			if(result == JFileChooser.APPROVE_OPTION)
			{
				fileDir = (("" + file.getCurrentDirectory().toString()) + "\\" + file.getSelectedFile().getName());
				game.saveGame(new File (fileDir));
			}
		}
	};
	
    private TransferHandler dndHandler = new TransferHandler("icon")
    {
    	ChessTiles source = null;
    	ChessTiles target = null;

		
    	@Override
    	public int getSourceActions (JComponent c)
    	{
    		return MOVE;
    	}

        @Override
	    public void exportAsDrag(JComponent comp, InputEvent e, int action) 
	    {
	   		this.source = (ChessTiles) comp;
	        super.exportAsDrag(comp, e, action);
	    }

      	@Override
	    protected void exportDone(JComponent source, Transferable data, int action)
	    {
	        if (action == MOVE)
	        {
	            ((ChessTiles) source).setIcon(null);
	            setChessPieceIcon();
	            setGraveyardIcon();
	            setPlayerMoveCount();
	            setPlayerToMove();
	        }
	    }
	    
        @Override
        public boolean importData(JComponent c, Transferable t) 
        {
        	target = (ChessTiles) c;

        	boolean moveFlag = game.isValidMove(source.getCoorX(), source.getCoorY(), target.getCoorX(), target.getCoorY()); 	
			
        	if (moveFlag)
        	{
        		return super.importData(c, t);
        		
        	}

        	else
        	{
        		return false;
        	}
        }
    };

	public Controller(MainFrame mainFrame, PlayingFrame playingFrame)
	{
		this.mainFrame = mainFrame;
		this.playingFrame = playingFrame;
		setListeners();
	}
	
	private void setChessPieceIcon()
	{
		for (int i = 0; i < game.getCoordinate().length; i++)
		{
			for (int j = 0; j < game.getCoordinate()[i].length; j++)
			{
				if (game.getCoordinate()[i][j].getChessPiece() != null)
				{
					playingFrame.setChessPieceIcon(i, j, game.getCoordinate()[i][j].getChessPiece().getIcon());
				}		
				else
				{
					playingFrame.clearChessPieceIcon(i, j);
				}		
			}
		}
	}

	
	private void setGraveyardIcon()
	{
		playingFrame.setGraveyardIcon("Green", game.getGraveyard("Green"));

		playingFrame.setGraveyardIcon("Orange", game.getGraveyard("Orange"));
	}

	
	private void setListeners()
	{
		playingFrame.addBacktoMenuListener(backToMenuListener);
		playingFrame.addSaveGameListener(saveGameListener);

		for (int i = 0; i < 7; i++)
		{
			for (int j = 0; j < 7; j++)
			{
				playingFrame.addChessTileListener(i, j, dndListener, dndHandler);	
			}
		}

		mainFrame.addStartGameListener(startGameListener);
		mainFrame.addLoadGameListener(loadGameListener);
	}

	
	private void setPlayerMoveCount()
	{
		playingFrame.setPlayerMoveCount(game.getPlayerToMove(), game.getMoveCount());
	}

	
	private void setPlayerToMove()
	{
		playingFrame.setPlayerToMove(game.getPlayerToMove());
	}
}