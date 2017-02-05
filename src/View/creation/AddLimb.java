package View.creation;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Limb;

public class AddLimb extends JFrame implements ActionListener{
	
	private JPanel frame;
	private JComboBox<String> listLimbs;
	private JButton newLimb;
	private JButton accept;
	private JButton cancel;
	private CreationLimbs parent;
	
	private String sTitleAddLimb;
	private String sButtonAccept;
	private String sButtonCancel;
	private String sNewButton;
	
	public AddLimb(CreationLimbs parent){
		super();
		
		initString();
		
		this.parent = parent;
		frame = new JPanel();
		frame.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		String[] datas = getLimbs();
		listLimbs = new JComboBox<String>(datas);
		newLimb = new JButton(sNewButton);
		newLimb.addActionListener(this);
		newLimb.setPreferredSize(new Dimension(0,0));
		accept = new JButton(sButtonAccept);
		accept.addActionListener(this);
		cancel = new JButton(sButtonCancel);
		cancel.addActionListener(this);
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.weighty = 0;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = (new Insets(10, 20, 10, 5));
		frame.add(listLimbs,c);
		c.gridx = 1;
		c.weightx = 0;
		c.insets = (new Insets(10, 20, 10, 40));
		frame.add(newLimb,c);
		c.insets = (new Insets(10, 20, 10, 40));
		c.weightx = 1;
		c.gridy = 1;
		c.gridx = 0;
		frame.add(accept,c);
		c.gridx = 1;
		c.insets = (new Insets(10, 0, 10, 20));
		frame.add(cancel,c);
		
		this.setContentPane(frame);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension screenSize = new Dimension(350,150);
		this.setSize(screenSize);
		this.setTitle(sTitleAddLimb);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private String[] getLimbs() {
		File folder = new File("limbs");
		File[] listOfFiles = folder.listFiles();
		String[] tab = new String[listOfFiles.length];
		for(int i = 0; i<tab.length; i++){
			tab[i] = listOfFiles[i].getName().substring(0, listOfFiles[i].getName().lastIndexOf("."));
		}
		return tab;
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
			sTitleAddLimb = prop.getProperty("LIMBS_ADD");
			sButtonAccept = prop.getProperty("BUTTON_ACCEPT");
			sButtonCancel = prop.getProperty("BUTTON_CANCEL");
			sNewButton = prop.getProperty("BUTTON_NEW");
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == newLimb){
			new CreateLimb(parent);
		}
		if(e.getSource() == accept){
			parent.addLimb((String)(listLimbs.getSelectedItem()));
		}
		this.dispose();
	}
}
