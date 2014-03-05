package javaguibasics;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyButton extends JButton implements ObjectLinker
{
	//stuff
	
	public static enum Type { JUMPING, NULL };
	
	private String text = "";
	public Type type = Type.NULL;
	
	int width, height, parentWidth, parentHeight;
	int xpos, ypos;
	
	public MyButton(int x, int y, int w, int h, String message)
	{
		super(message);
		text = message;
		this.setLocation(0,0);
		this.setSize(w,h);
		type = Type.NULL;
	}
	
	public MyButton(int w, int h, String message)
	{
		super(message);
		text = message;
		this.setLocation(x,y);
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
		super.setText(t)
		text = t;
	}
	
	@Override
	public void setPosition(int x, int y)
	{
		super.setPosition(x,y);
		xpos = x;
		ypos = y;
	}
	
	@Override
	public void setSize(int w, int h)
	{
		super.setSize(w,h);
		width = w; height = h;
	}
	
	public void click()
	{
		if (type == Type.JUMPING) this.jump();
		if (type == Type.NULL) this.setText("CLICKED");
	}
	
	public void jump()
	{
		int dx = ppw - width;
		int dy = pph - height;
		
		int x = (int) (Math.random() * dx);
		int y = (int) (Math.random() * dy);
		
		this.setLocation(x,y);
	}
	
	public int getXposition() { return xpos; }
	public int getYposition() { return ypos; }
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	
	private ObjectLinker nextInChain;
	private ObjectLinkder prevInChain;
	
	/** Get the next object in the chain. */
	@Override
	public ObjectLinker nextLink()
	{
		return nextInChain;
	}
	
	/** Get the previous object in the chain. */
	@Override
	public ObjectLinker prevLink()
	{
		return prevInChain;
	}
	
	/** Insert a new link before this one. */
	@Override
	public void insertBefore(ObjectLinker obj)
	{
		if (preInChain != obj)
		{
			prevInChain = obj;
			obj.insertAfter(this);
		}
	}
	
	/** Insert a new link after this one. */
	@Override
	public void insertAfter(ObjectLinker obj)
	{
		if (nextInChain != obj)
		{
			nextInChain = obj;
			obj.insertBefore(this);
		}
	}
	
}
