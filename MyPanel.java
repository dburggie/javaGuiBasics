package javaguibasics;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyPanel extends JPanel implements RegisterParents
{
	
	int xpos, ypos, width, height;
	
	MyFrame parentFrame = null;
	MyPanel parentPanel = null;
	
	public MyPanel(int x, int y, int w, int h)
	{
		super();
		xpos = x; ypos = y; width = w; height = h;
		this.setLayout(null);
		this.update();
	}
	
	public MyFrame getParentFrame()
	{
		return parentFrame;
	}
	
	@Override
	public void registerFrame(MyFrame frame)
	{
		parentFrame = frame;
	}
	@Override
	public void registerPanel(MyPanel panel)
	{
		parentPanel = panel;
		parentFrame = panel.getParentFrame();
	}
	
	public void update()
	{
		this.setLocation(xpos, ypos);
		this.setSize(width, height);
		this.setVisible(true);
	}
	
	@Override
	public void add(MyButton button)
	{
		super.add(button);
		button.registerPanel(this);
		if (parentFrame != null)
		{
			button.registerFrame(parentFrame);
		}
	}
	
	@Override
	public void add(MyLabel label)
	{
		super.add(label);
		label.registerPanel(this);
		if (parentFrame != null)
		{
			label.registerFrame(parentFrame);
		}
	}
	
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	
}
