package javaguibasics;

public class test
{
	
	public static void main(String [] args)
	{
		MyFrame frame = new MyFrame();
		
		MyPanel panel = frame.getMainPanel();
		
		panel.add(new MyButton(0,0,100,30,"Press and I'll Jump", MyButton.Type.JUMPING) );
		
	}
	
}
