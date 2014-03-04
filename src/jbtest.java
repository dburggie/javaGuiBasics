
import javaguibasics.JumpButton;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class jbtest extends JFrame implements ActionListener
{
	
	private JumpButton button;
	
	public jbtest(String s)
	{
		super(s);
		
		this.setDefaultLookAndFeelDecorated(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		Container con = this.getContentPane();
		
		button = new JumpButton(500, 500, 75, 20, "JUMP");
		button.addActionListener(this);
		
		JPanel p = new JPanel();
		p.setLocation(0,0);
		p.setSize(500,500);
		p.setLayout(null);
		p.setOpaque(true);
		p.add(button);
		
		con.add( p );
		
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		
		Object source = event.getSource();
		
		if (source == button) button.click();
		
	}
	
	public static void main(String [] args) { new jbtest("Jumping Button"); }
	
}



