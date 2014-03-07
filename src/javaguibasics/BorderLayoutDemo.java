
package javaguibasics;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class BorderLayoutDemo extends JPanel implements ActionListener
{
	
	JButton bodyButton, skyButton, previewButton, cameraButton, renderButton;
	JPanel bodyPanel, skyPanel, previewPanel, cameraPanel, renderPanel;
	JScrollPane bodyScrollPane;
	
	Border etched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	
	public static void main(String [] args)
	{
		CreateAndViewGUI();
		
	}
	
	public static void CreateAndViewGUI()
	{
		
		JFrame frame = new JFrame("Demo of BorderLayout");
		frame.setDefaultLookAndFeelDecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,600);
		
		Container con = frame.getContentPane();
		
		BorderLayoutDemo content = new BorderLayoutDemo();
		
		con.add(content);
		
		frame.setVisible(true);
		
		
		
	}
	
	public BorderLayoutDemo()
	{
		super();
		setLayout(new BorderLayout());
		setSize( new Dimension(600,600) );
		fillPanel();
		setOpaque(true);
	}
	
	
	public void actionPerformed(ActionEvent event)
	{
		
		System.out.println("Something Happened!");
		
		Object source = event.getSource();
		
		if (source == bodyButton)
		{
			System.out.println("Add a new Body!");
		}
		
		else if (source == skyButton)
		{
			System.out.println("Setting Sky!");
		}
		
		else if (source == cameraButton)
		{
			System.out.println("Setting Camera!");
		}
		
		else if (source == previewButton)
		{
			System.out.println("Refreshing Preview!");
		}
		
		else if (source == renderButton)
		{
			System.out.println("Rendering");
		}
		
	}
	
	private void addButtonToPanel(JPanel p, JButton b)
	{
		b.setPreferredSize( new Dimension(200,20));
		p.add(b, BorderLayout.PAGE_END);
		b.addActionListener(this);
	}
	
	private void fillPanel()
	{
		JPanel panel;
		JButton button;
		
		
		bodyPanel = new JPanel( new BorderLayout() );
		
		bodyButton = new JButton("Add Body");
		bodyButton.setPreferredSize( new Dimension(200,20));
		bodyPanel.add(bodyButton, BorderLayout.PAGE_END);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(200,1000);
		for (int i = 0; i < 10; i += 1)
		{
			button = new JButton("button " + Integer.toString(i));
			button.setSize(200,90);
			button.setLocation(0, 100 * i);
			panel.add(button);
		}
		
		bodyScrollPane = new JScrollPane(panel);
		bodyPanel.add(bodyScrollPane, BorderLayout.CENTER);
		
		add(bodyPanel, BorderLayout.LINE_START);
		
		//setup preview area
		previewButton = new JButton("refresh preview");
		previewButton.setPreferredSize( new Dimension(400,20));
		previewPanel = new JPanel(new BorderLayout());
		previewPanel.add(previewButton, BorderLayout.PAGE_END);
		panel = new JPanel();
		panel.setPreferredSize( new Dimension(400,400));
		panel.setBorder(etched);
		previewPanel.add(panel, BorderLayout.CENTER);
		add(previewPanel, BorderLayout.CENTER);
		
		
		//add footer panels
		panel = new JPanel(new BorderLayout());
		panel.setPreferredSize( new Dimension(600,200));
		skyPanel = new JPanel(new BorderLayout() );
		skyPanel.setPreferredSize( new Dimension(200,200));
		panel.add(skyPanel, BorderLayout.LINE_START);
		cameraPanel = new JPanel();
		cameraPanel.setPreferredSize( new Dimension(200,200));
		panel.add(cameraPanel, BorderLayout.CENTER);
		renderPanel = new JPanel();
		renderPanel.setPreferredSize( new Dimension(200,200));
		panel.add(renderPanel, BorderLayout.LINE_END);
		add(panel, BorderLayout.PAGE_END);
		
		//setup sky area
		panel = new JPanel();
		panel.setBorder(etched);
		skyPanel.add(panel, BorderLayout.CENTER);
		
		skyButton = new JButton("Set Sky");
		addButtonToPanel(skyPanel, skyButton);
		
		//setup camera area
		panel = new JPanel();
		panel.setBorder(etched);
		cameraPanel.add(panel, BorderLayout.CENTER);
		
		cameraButton = new JButton("Set Camera");
		addButtonToPanel(cameraPanel, cameraButton);
		
		//setup render area
		panel = new JPanel();
		panel.setBorder(etched);
		renderPanel.add(panel, BorderLayout.CENTER);
		
		renderButton = new JButton("Render");
		addButtonToPanel(renderPanel, renderButton);
		
		
		
	}
	
}

