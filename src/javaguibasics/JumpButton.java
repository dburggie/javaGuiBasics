package javaguibasics;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JumpButton extends JButton
{
	
	int xMax, yMax;
	
	public JumpButton(int outer_w, int outer_h, int inner_w, int inner_h, String s)
	{
		super(s);
		xMax = outer_w - inner_w;
		yMax = outer_h - inner_h;
		this.setSize(inner_w, inner_h);
		this.click();
	}
	
	public void click()
	{
		int x = (int) (Math.random() * xMax);
		int y = (int) (Math.random() * yMax);
		this.setLocation(x,y);
	}
	
}
