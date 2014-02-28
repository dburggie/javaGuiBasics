package javaguibasics;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyButton extends JButton
{
	//stuff
	
	public static enum Type { JUMPING, NULL };
	
	private String text = "";
	public Type type = Type.NULL;
	
	MyPanel parentPanel = null;
	private int ppw = 0, pph = 0;
	
	MyFrame parentFrame = null;
	private int pfw = 0, pfh = 0;
	
	public MyButton(int x, int y, int w, int h, String messege, Type t)
	{
		super(messege);
		text = messege;
		this.setLocation(x,y);
		this.setSize(w,h);
		type = t;
	}
	/*
	public MyButton(int x, int y, int w, int h, String messege)
	{
		MyButton(x,y,w,h,messege,Type.NULL);
	}
	
	public MyButton(int x, int y, int w, int h)
	{
		MyButton(x,y,w,h,"",Type.NULL);
	}
	*/
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
		button.addActionListener(parentFrame);
	}
	
	@Override
	public void registerPanel(MyPanel panel)
	{
		parentPanel = panel;
		ppw = panel.getWidth();
		pph = panel.getHeight();
		parentFrame = panel.getParentFrame();
	}
	
	public void click()
	{
		if (type = Type.JUMPING) this.jump();
	}
	
	public void jump()
	{
		int dx = ppw - width;
		int dy = pph - height;
		
		int x = (int) (Math.random() * dx);
		int y = (int) (Math.random() * dy);
		
		this.setLocation(x,y);
	}
}
