import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class clickgame extends JFrame implements ActionListener
{
	
	private JPanel mainPane;
	private JLabel walletLabel;
	private JLabel bankLabel;
	private JLabel clickLabel;
	private JLabel currentPPC;
	private JLabel recordPPC;
	private JButton walletButton;
	private JButton bankButton;
	private JButton resetButton;
	private int bank = 0;
	private int wallet = 0;
	private int clicks = 0;
	private double score = 0.0, highscore = 0.0;
	
	public clickgame()
	{
		super("GUITEST EXTREME");
		
		this.setDefaultLookAndFeelDecorated(true);
		
		//setBounds(100,100,300,100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // HOW ABOUT WE QUIT WHEN WE QUIT?
		this.setSize(500,500);
		
		Container con = this.getContentPane(); // inherit main frame
		mainPane = this.newPanel();
		con.add( mainPane );
		
		setVisible(true); // display this frame
		
	}
	
	private JPanel newPanel() // the frame constructor method
	{
		
		JPanel newPane = new JPanel();
		newPane.setSize(500,500);
		newPane.setLayout(null);
		
		
		
		// ##### BEGIN SCORE TEXT PANE #####
		JPanel textPane = new JPanel();
		textPane.setLayout(null); // I DON'T KNOW WHAT THIS DOES
		textPane.setLocation(10,0);
		textPane.setSize(300, 30);
		newPane.add(textPane);
		
		JLabel walletText = new JLabel("In Wallet");
		walletText.setLocation(0,0);
		walletText.setSize(100,30);
		walletText.setHorizontalAlignment(0); // WHY ZERO
		textPane.add(walletText);
		
		JLabel bankText = new JLabel("In Bank");
		bankText.setLocation(100,0);
		bankText.setSize(100,30);
		bankText.setHorizontalAlignment(0);
		textPane.add(bankText);
		
		JLabel clickText = new JLabel("Clicks");
		clickText.setLocation(200,0);
		clickText.setSize(100,30);
		clickText.setHorizontalAlignment(0);
		textPane.add(clickText);
		
		
		// ##### BEGIN SCORES PANE #####
		JPanel scorePane = new JPanel();
		scorePane.setLayout(null);
		scorePane.setLocation(10,40);
		scorePane.setSize(300, 30);
		newPane.add(scorePane);
		
		walletLabel = new JLabel("" + wallet);
		walletLabel.setLocation(0,0);
		walletLabel.setSize(100,30);
		walletLabel.setHorizontalAlignment(0);
		scorePane.add(walletLabel);
		
		bankLabel = new JLabel("" + bank);
		bankLabel.setLocation(100,0);
		bankLabel.setSize(100,30);
		bankLabel.setHorizontalAlignment(0);
		scorePane.add(bankLabel);
		
		clickLabel = new JLabel( "" + clicks );
		clickLabel.setLocation(200,0);
		clickLabel.setSize(100,30);
		clickLabel.setHorizontalAlignment(0);
		scorePane.add(clickLabel);
		
		
		
		// ##### BEGIN BUTTON PANE #####
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(null);
		buttonPane.setLocation(10, 80);
		buttonPane.setSize(300, 70);
		newPane.add(buttonPane);
				
		walletButton = new JButton("+1");
		walletButton.setLocation(0, 0);
		walletButton.setSize(150, 30);
		walletButton.addActionListener(this);
		buttonPane.add(walletButton);
		
		bankButton = new JButton("Bank");
		bankButton.setLocation(150, 0);
		bankButton.setSize(150, 30);
		bankButton.addActionListener(this);
		buttonPane.add(bankButton);
		
		resetButton = new JButton("reset");
		resetButton.setLocation(100,40);
		resetButton.setSize(100,30);
		resetButton.addActionListener(this);
		buttonPane.add(resetButton);
		
		
		// ##### BEGIN RECORD TEXT PANE #####
		JPanel recordTextPane = new JPanel();
		recordTextPane.setLayout(null);
		recordTextPane.setLocation(10, 160);
		recordTextPane.setSize(300,30);
		newPane.add(recordTextPane);
		
		JLabel currentText = new JLabel("Current Points/Click");
		currentText.setLocation(0,0);
		currentText.setSize(150,30);
		currentText.setHorizontalAlignment(0);
		recordTextPane.add(currentText);
		
		JLabel recordText = new JLabel("Record Points/Click");
		recordText.setLocation(150,0);
		recordText.setSize(150,30);
		recordText.setHorizontalAlignment(0);
		recordTextPane.add(recordText);
		
		
		
		// ##### BEGIN RECORDS PANE #####
		JPanel recordScorePane = new JPanel();
		recordScorePane.setLayout(null);
		recordScorePane.setLocation(10,200);
		recordScorePane.setSize(300,30);
		newPane.add(recordScorePane);
		
		currentPPC = new JLabel("" + score);
		currentPPC.setLocation(0,0);
		currentPPC.setSize(150,30);
		currentPPC.setHorizontalAlignment(0);
		recordScorePane.add(currentPPC);
		
		recordPPC = new JLabel("" + highscore);
		recordPPC.setLocation(150,0);
		recordPPC.setSize(150,30);
		recordPPC.setHorizontalAlignment(0);
		recordScorePane.add(recordPPC);
		
		newPane.setOpaque(true);
		
		return newPane;
	}
	
	private void update()
	{
		bank += bank / 10;
		if (clicks != 0)
		{
			score = (double) (wallet + bank) / clicks;
		}
		walletLabel.setText( "" + wallet );
		bankLabel.setText( "" + bank );
		clickLabel.setText( "" + clicks );
		currentPPC.setText( "" + score );
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		
		Object eventSource = event.getSource();
		
		if (eventSource == walletButton)
		{
			wallet += 1;
			clicks += 1;
			this.update();
		}
		
		if (eventSource == bankButton)
		{
			bank += wallet;
			wallet = 0;
			clicks += 1;
			this.update();
		}
		
		if (eventSource == resetButton)
		{
			if (score > highscore)
			{
				highscore = score;
				recordPPC.setText( "" + highscore );
			}
			wallet = 0;
			bank = 0;
			clicks = 0;
			score = 0.0;
			this.update();
		}
	}
	
	public static void main(String args[]) { new clickgame(); }
	
}

/*
	
	
	
*/
