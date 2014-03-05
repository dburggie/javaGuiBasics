
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Buttons { 
	
	public JButton preview, bodies, render, camera, sky;

	public Buttons() { bodies = null; preview = null; sky = null; camera = null; render = null; }
	
}

class Panels
{
	
	public JPanel bodies, preview, sky, camera, render;
	
	public Panels() { bodies = null; preview = null; sky = null; camera = null; render = null; }
	
}

class Labels
{
	
	public JLabel bodies, preview, sky, camera, render;
	
	public Labels() { bodies = null; preview = null; sky = null; camera = null; render = null; }
	
}

public class layout extends JFrame implements ActionListener
{
	public static void main(String [] args) { new layout(); }
	
	private Buttons buttons = new Buttons();
	private Panels panels = new Panels();
	private Labels labels = new Labels();
	
	private JPanel primary;
	
	
	public layout()
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
	
	private JPanel init()
	{
		
		JPanel panel = new JPanel();
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
	
	private void update()
	{
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		
		Object source = event.getSource();
		
		if (source == buttons.bodies)
		{
			labels.bodies.setText("Button: Pressed");
		}
		
		if (source == buttons.preview)
		{
			labels.preview.setText("Button: Pressed");
		}
		
		if (source == buttons.sky)
		{
			labels.sky.setText("Button: Pressed");
		}
		
		if (source == buttons.camera)
		{
			labels.camera.setText("Button: Pressed");
		}
		
		if (source == buttons.render)
		{
			labels.render.setText("Button: Pressed");
		}
		
		this.update();
	}
	
	private JPanel makeRenderPanel()
	{
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(200,200);
		panel.setLocation(400,400);
		panels.render = panel;
		
		JLabel text = new JLabel("Render Box");
		text.setSize(200,50);
		text.setLocation(0,0);
		text.setHorizontalAlignment(0);
		panel.add(text);
		labels.render = text;
		
		JButton button = new JButton("RENDER");
		button.setSize(200,20);
		button.setLocation(0,180);
		button.addActionListener(this);
		panel.add(button);
		buttons.render = button;
		
		return panel;
		
	}
	
	private JPanel makeCameraPanel()
	{
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(200,200);
		panel.setLocation(200,400);
		panels.camera = panel;
		
		JLabel text = new JLabel("Camera");
		text.setSize(200,50);
		text.setLocation(0,0);
		text.setHorizontalAlignment(0);
		panel.add(text);
		labels.camera = text;
		
		JButton button = new JButton("reset Camera");
		button.setSize(200,20);
		button.setLocation(0,180);
		button.addActionListener(this);
		panel.add(button);
		buttons.camera = button;
		
		return panel;
		
	}
	
	private JPanel makeBodyPanel()
	{
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(200,400);
		panel.setLocation(0,0);
		panels.bodies = panel;
		
		JLabel text = new JLabel("Body Panel");
		text.setSize(200,50);
		text.setLocation(0,0);
		text.setHorizontalAlignment(0);
		panel.add(text);
		labels.bodies = text;
		
		JButton button = new JButton("Add a new Body!");
		button.setLocation(0,380);
		button.setSize(200,20);
		button.addActionListener(this);
		panel.add(button);
		buttons.bodies = button;
		
		return panel;
		
	}
	
	private JPanel makePreviewPanel()
	{
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(400,400);
		panel.setLocation(200,0);
		panels.preview = panel;
		
		JLabel text = new JLabel("This is the preview panel.");
		text.setSize(400,50);
		text.setLocation(0,0);
		text.setHorizontalAlignment(0);
		panel.add(text);
		labels.preview = text;
		
		JButton button = new JButton("refresh preview");
		button.setSize(400,20);
		button.setLocation(0,380);
		button.addActionListener(this);
		panel.add(button);
		buttons.preview = button;
		
		return panel;
		
	}
	
	private JPanel makeSkyPanel()
	{
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(200,200);
		panel.setLocation(0,400);
		panels.sky = panel;
		
		JLabel text = new JLabel("Sky Panel");
		text.setSize(200,50);
		text.setLocation(0,0);
		text.setHorizontalAlignment(0);
		panel.add(text);
		labels.sky = text;
		
		JButton button = new JButton("Set Sky");
		button.setSize(200,20);
		button.setLocation(0,180);
		button.addActionListener(this);
		panel.add(button);
		buttons.sky = button;
		
		return panel;
		
	}
	
}
