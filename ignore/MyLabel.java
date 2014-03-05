package javaguibasics;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyLabel extends JLabel implements RegisterParents
{
	public static enum Type { TITLE, NULL };
	private String text = "";
	public Type type = Type.NULL;
	
	MyPanel parentPanel = null;
	private int ppw = 0, pph = 0;
	
	MyFrame parentFrame = null;
	private int pfw = 0, pfh = 0;
	
	public MyLabel(int x, int y, int w, int h, String t)
	{
		super(t);
		this.setLocation(x,y);
		this.setSize(w,h);
	}
	
	public void setType(Type t)
	{
		type = t;
	}
	
	@Override
	public void registerFrame(MyFrame frame)
	{
		parentFrame = frame;
		pfw = panel.getWidth();
		pfh = panel.getHeight();
	}
	@Override
	public void registerPanel(MyPanel panel)
	{
		parentPanel = panel;
		ppw = panel.getWidth();
		pph = panel.getHeight();
		parentFrame = panel.getParentFrame();
	}
}
