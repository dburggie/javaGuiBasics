package javaguibasics;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class ScrollPaneDemo extends JFrame
{
	
	JButton button;
	JScrollPane scrollPane;
	JPanel buttonPanel;
	JPanel innerPanel;
	
	private void populate()
	{
		
		Container p = getContentPane();
		
		innerPanel = new JPanel( new BoxLayout(innerPanel, BoxLayout.Y_AXIS) );
		JButton b;
		for (int i = 0; i < 30; i += 1)
		{
			b = new JButton("button " + Integer.toString(i));
			b.setSize(300,50);
			innerPanel.add(b);
		}
		
		buttonPanel = new JPanel( new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS) );
		buttonPanel.setBorder( BorderFactory.createEmptyBorder(0,10,10,10) );
		button = new JButton("Button");
		button.setSize(75,25);
		buttonPanel.add(button);
		
		scrollPane = new JScrollPane(innerPanel);
		scrollPane.setBorder( BorderFactory.createEmptyBorder(10,10,10,10) );
		
		p.add(scrollPane);
		p.add(buttonPanel);
		
		//p.setOpaque(true);
		
		setContentPane(p);
		
	}
	
	private ScrollPaneDemo()
	{
		
		super("ScrollPaneDemo");
		setLayout( new BoxLayout(getContentPane(), BoxLayout.Y_AXIS) );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private static void createAndShowGUI()
	{
		//Create and set up the window.
		ScrollPaneDemo demo = new ScrollPaneDemo();
		demo.populate();
		
		//Display the window.
		demo.pack();
		demo.setVisible(true);
	}
	
	public static void main(String[] args) 
	{
		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(
			new Runnable()
			{
				public void run() {
					createAndShowGUI();
				}
			});
	}
	
}
