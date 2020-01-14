import javax.swing.*;  

public class Result {  
	JFrame f;  
	Result (String color){  
	    f=new JFrame();  
	    if(color == "Draw")
	    {
	    	JOptionPane.showMessageDialog(f,"Draw!");
	    }
	    else
	    {
	    	JOptionPane.showMessageDialog(f,color + " has won the game!");
	    }
	}  
}