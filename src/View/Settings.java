package View;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class Settings extends JFrame implements ActionListener{

	private JPanel frame;
	private JLabel lblLanguage;
	private JComboBox<String> listLanguage;
	private JButton accept;
	private JButton cancel;
	
	private String sTitle;
	private String sLblLanguage;
	private String sLanguageFr;
	private String sLanguageEn;
	private String sButtonAccept;
	private String sButtonCancel;
	
	public Settings(){
		super();
		
		initString();
		
		frame = new JPanel();
		frame.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		lblLanguage = new JLabel(sLblLanguage, SwingConstants.RIGHT);
		String[] datas = {sLanguageEn,sLanguageFr};
		listLanguage = new JComboBox<String>(datas);
		accept = new JButton(sButtonAccept);
		accept.addActionListener(this);
		cancel = new JButton(sButtonCancel);
		cancel.addActionListener(this);
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0;
		c.weighty = 0;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = (new Insets(10, 20, 10, 0));
		frame.add(lblLanguage,c);
		c.gridx = 1;
		c.insets = (new Insets(10, 5, 10, 20));
		frame.add(listLanguage,c);
		c.insets = (new Insets(10, 20, 10, 0));
		c.gridy = 1;
		c.gridx = 0;
		frame.add(accept,c);
		c.gridx = 1;
		c.insets = (new Insets(10, 40, 10, 20));
		frame.add(cancel,c);
		
		this.setContentPane(frame);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension screenSize = new Dimension(250,150);
		this.setSize(screenSize);
		this.setTitle(sTitle);
		this.setMinimumSize(new Dimension(250,150));
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
			sLblLanguage = prop.getProperty("LBL_LANGUAGE");
			sLanguageFr = prop.getProperty("LANGUAGE_FR");
			sLanguageEn = prop.getProperty("LANGUAGE_EN");
			sButtonAccept = prop.getProperty("BUTTON_ACCEPT");
			sButtonCancel = prop.getProperty("BUTTON_CANCEL");
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource() == accept){
		Properties prop = new Properties();
		OutputStream output = null;
		try {
			output = new FileOutputStream("config.properties");
			if(listLanguage.getSelectedItem() == sLanguageFr){
				prop.setProperty("language","FR_fr");
			}
			if(listLanguage.getSelectedItem() == sLanguageEn){
				prop.setProperty("language", "EN_en");
			}
			prop.store(output, null);
			output.close();
		} catch (Exception e2) {
		}
	}
	new Menu();
	this.dispose();
	
}
}
