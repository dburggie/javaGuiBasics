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
	
	int width, height, parentWidth = 0, parentHeight = 0;
	int xpos, ypos;
	
	public MyButton(int x, int y, int w, int h, String message)
	{
		super(message);
		text = message;
		this.setLocation(x,y);
		this.setSize(w,h);
		type = Type.NULL;
	}
	
	public MyButton(int w, int h, String message)
	{
		super(message);
		text = message;
		this.setLocation(0,0);
		this.setSize(w,h);
		type = Type.NULL;
	}
	
	public void setType(Type t)
	{
		type = t;
	}
	
	@Override
	public void setText(String t)
	{
		super.setText(t);
		text = t;
	}
	
	@Override
	public void setLocation(int x, int y)
	{
		super.setLocation(x,y);
		xpos = x;
		ypos = y;
	}
	
	@Override
	public void setSize(int w, int h)
	{
		super.setSize(w,h);
		width = w; height = h;
	}
	
	public void setParent(MyPanel p)
	{
		parentWidth = p.getWidth();
		parentHeight = p.getHeight();
	}
	
	public void click()
	{
		if (type == Type.JUMPING) this.jump();
		if (type == Type.NULL) this.setText("CLICKED");
	}
	
	public void jump()
	{
		int dx = Math.max(0, parentWidth - width);
		int dy = Math.max(0, parentHeight - height);
		
		int x = (int) (Math.random() * dx);
		int y = (int) (Math.random() * dy);
		
		this.setLocation(x,y);
	}
	
	public int getXposition() { return xpos; }
	public int getYposition() { return ypos; }
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	public String getText() { return text; }
	
	private MyButton nextInChain;
	private MyButton prevInChain;
	
	/** Get the next object in the chain. */
	public MyButton nextLink()
	{
		return nextInChain;
	}
	
	/** Get the previous object in the chain. */
	public MyButton prevLink()
	{
		return prevInChain;
	}
	
	/** Insert a new link before this one. */
	public void insertBefore(MyButton obj)
	{
		if (prevInChain != obj)
		{
			prevInChain = obj;
			obj.insertAfter(this);
		}
	}
	
	/** Insert a new link after this one. */
	public void insertAfter(MyButton obj)
	{
		if (nextInChain != obj)
		{
			nextInChain = obj;
			obj.insertBefore(this);
		}
	}
	
}
