package javaguibasics;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class MyFrame extends JFrame implements ActionListener
{
	MyPanel mainPanel = new MyPanel(0,0,500,500);
	int width, height;
	
	public MyFrame()
	{
		super("Title Emptor");
		this.setDefaultLookAndFeelDecorated(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,550);
		width = 500; height = 500;
		
		Container con = this.getContentPane(); // inherit main frame
		con.add( mainPanel );
		
		setVisible(true);
	}
	
	public MyPanel getMainPanel()
	{
		return mainPanel;
	}
	
	@Override
	public void add(MyPanel panel)
	{
		super.add(panel);
		panel.registerFrame(this);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		
		Object source = event.getSource();
		
		if (source instanceof MyButton) source.getClass().click();
	
	}
	
}
