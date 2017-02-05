package View;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;


public class Menu extends JFrame implements ActionListener{

	private JPanel frame;
	private JButton local;
	private JButton online;
	private JButton creation;
	private JButton howToPlay;
	private JButton settings;
	private JButton exit;
	
	private String sTitle;
	private String sButtonLocal;
	private String sButtonOnline;
	private String sButtonCreation;
	private String sButtonHowToPlay;
	private String sButtonSettings;
	private String sButtonExit;
	
	public Menu(){
		super();
		
		initString();
		
		frame = new JPanel();
		frame.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		local = new JButton(sButtonLocal);
		online = new JButton(sButtonOnline);
		online.setEnabled(false);
		creation = new JButton(sButtonCreation);
		creation.addActionListener(this);
		howToPlay = new JButton(sButtonHowToPlay);
		settings = new JButton(sButtonSettings);
		settings.addActionListener(this);
		exit = new JButton(sButtonExit);
		exit.addActionListener(this);
		
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.weighty = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = (new Insets(10, 20, 10, 20));
		frame.add(local, c);
		c.gridy = 1;
		frame.add(online,c);
		c.gridy = 2;
		frame.add(creation,c);
		c.gridy = 3;
		frame.add(howToPlay,c);
		c.gridy = 4;
		frame.add(settings,c);
		c.gridy = 5;
		frame.add(exit,c);
		
		this.setContentPane(frame);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension screenSize = new Dimension(300,400);
		this.setSize(screenSize);
		this.setTitle(sTitle);
		this.setMinimumSize(new Dimension(200,275));
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}


	private void initString() {
		
		Properties prop = new Properties();
		InputStream input = null;
		String language = "EN_en";
		try{
			input = new FileInputStream("config.properties");
			prop.load(input);
			language = prop.getProperty("language");
			input.close();
			
			input = new FileInputStream("lang/" + language + ".properties");
			prop.load(new InputStreamReader(input, Charset.forName("UTF-8")));
			sTitle = prop.getProperty("TITLE");
			sButtonLocal = prop.getProperty("BUTTON_LOCAL");
			sButtonOnline = prop.getProperty("BUTTON_ONLINE");
			sButtonCreation = prop.getProperty("BUTTON_CREATION");
			sButtonHowToPlay = prop.getProperty("BUTTON_HOWTOPLAY");
			sButtonSettings = prop.getProperty("BUTTON_SETTINGS");
			sButtonExit = prop.getProperty("BUTTON_EXIT");
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exit) System.exit(0);
		if(e.getSource() == settings){
			new Settings();
			this.dispose();
		}
		if(e.getSource() == creation){
			new Creation();
			this.dispose();
		}
	}
	
}
