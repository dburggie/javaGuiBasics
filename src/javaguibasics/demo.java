
package javaguibasics;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class demo extends JFrame implements ActionListener
{
	public static void main(String [] args) { new layout(); }
	
	MyButton topButton = null, bottomButton = null;
	
	private MyPanel primary;
	
	
	public demo()
	{
		super("Test Layout");
		
		this.setDefaultLookAndFeelDecorated(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(650,650);
		
		Container con = this.getContentPane(); // inherit main frame
		primary = this.init();
		con.add( primary );
		
		this.setVisible(true);
	}
	
	private MyPanel init()
	{
		
		MyPanel panel = new MyPanel();
		panel.setLayout(null);
		panel.setSize(600,600);
		panel.setLocation(0,0);
		
		panel.add( this.makeBodyPanel() );
		panel.add( this.makePreviewPanel() );
		panel.add( this.makeSkyPanel() );
		panel.add( this.makeCameraPanel() );
		panel.add( this.makeRenderPanel() );
		
		panel.setOpaque(true);
		
		return panel;
		
	}
	
	public void addButton(MyButton b)
	{
		if (bottomButton == null)
		{
			topButton = b; bottomButton = b;
		}
		else
		{
			bottomButton.insertAfter(b);
		}
	}
	
	private void update()
	{
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		
		Object source = event.getSource();
		
		MyButton b = topButton;
		while ( b != null )
		{
			if (source == b)
			{
				b.click();
			}
			b = b.nextLink();
		}
		
		this.update();
	}
	
	private MyPanel makeRenderPanel()
	{
		MyPanel panel = new MyPanel(400,400,200,200);
		
		JLabel text = new JLabel("Render Box");
		text.setSize(200,50);
		text.setLocation(0,0);
		text.setHorizontalAlignment(0);
		panel.add(text);
		
		MyButton button = new MyButton(0,180,200,20,"RENDER");
		button.addActionListener(this);
		panel.add( button );
		this.addButton( button );
		
		return panel;
		
	}
	
	private MyPanel makeCameraPanel()
	{
		MyPanel panel = new MyPanel(200,400,200,200);
		
		JLabel text = new JLabel("Camera");
		text.setSize(200,50);
		text.setLocation(0,0);
		text.setHorizontalAlignment(0);
		panel.add(text);
		
		MyButton button = new MyButton(0,180,200,20,"reset Camera");
		button.addActionListener(this);
		panel.add( button );
		this.addButton( button );
		
		return panel;
		
	}
	
	private MyPanel makeBodyPanel()
	{
		
		MyPanel panel = new MyPanel(0,0,200,400);
		
		JLabel text = new JLabel("Body Panel");
		text.setSize(200,50);
		text.setLocation(0,0);
		text.setHorizontalAlignment(0);
		panel.add(text);
		
		MyButton button = new MyButton(0,380,200,20,"Add a new Body!");
		button.addActionListener(this);
		panel.add( button );
		this.addButton( button );
		
		return panel;
		
	}
	
	private MyPanel makePreviewPanel()
	{
		MyPanel panel = new MyPanel(200,0,400,400);
		
		JLabel text = new JLabel("This is the preview panel.");
		text.setSize(400,50);
		text.setLocation(0,0);
		text.setHorizontalAlignment(0);
		panel.add(text);
		
		MyButton button = new MyButton(0,380,400,20,"refresh preview");
		button.addActionListener(this);
		panel.add( button );
		this.addButton( button );
		
		return panel;
		
	}
	
	private MyPanel makeSkyPanel()
	{
		
		MyPanel panel = new MyPanel(0,400,200,200);
		
		JLabel text = new JLabel("Sky Panel");
		text.setSize(200,50);
		text.setLocation(0,0);
		text.setHorizontalAlignment(0);
		panel.add(text);
		
		MyButton button = new MyButton(0,180,200,20,"Set Sky");
		button.addActionListener(this);
		panel.add( button );
		this.addButton( button );
		
		return panel;
		
	}
	
}
