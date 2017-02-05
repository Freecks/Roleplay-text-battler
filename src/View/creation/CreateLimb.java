package View.creation;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Limb;

public class CreateLimb extends JFrame implements ActionListener{

	private JPanel frame;
	private JLabel name;
	private JTextField nameValue;
	private JLabel description;
	private JTextArea descriptionValue;
	private JScrollPane descriptionScroll;
	private JButton accept;
	private JButton cancel;
	private CreationLimbs parent;
	
	private String sTitleCreateLimb;
	private String sName;
	private String sDescription;
	private String sButtonAccept;
	private String sButtonCancel;
	
	public CreateLimb(CreationLimbs parent){ // TODO : make it beautiful
		super();
		
		initString();
		
		this.parent = parent;
		frame = new JPanel();
		frame.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		name = new JLabel(sName);
		nameValue = new JTextField();
		description = new JLabel(sDescription);
		descriptionValue = new JTextArea();
		descriptionValue.setLineWrap(true);
		descriptionValue.setEditable(true);
		descriptionScroll = new JScrollPane(descriptionValue);
		descriptionScroll.setPreferredSize(new Dimension(0,0));
		accept = new JButton(sButtonAccept);
		accept.addActionListener(this);
		cancel = new JButton(sButtonCancel);
		cancel.addActionListener(this);
		
		c.gridx = 0;
		c.gridy = 0;
		c.fill = GridBagConstraints.BOTH;
		c.weighty = 0.5;
		frame.add(name,c);
		c.gridx++;
		c.weightx = 1;
		frame.add(nameValue,c);
		c.gridx--;
		c.gridy++;
		c.weightx = 0;
		frame.add(description,c);
		c.gridx++;
		c.weightx = 1;
		frame.add(descriptionScroll,c);
		c.gridx--;
		c.gridy++;
		frame.add(accept,c);
		c.gridx++;
		frame.add(cancel,c);
		
		this.setContentPane(frame);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension screenSize = new Dimension(350,150);
		this.setSize(screenSize);
		this.setTitle(sTitleCreateLimb);
		this.setResizable(false);
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
			sTitleCreateLimb = prop.getProperty("TITLE_CREATE_LIMB");
			sButtonAccept = prop.getProperty("BUTTON_ACCEPT");
			sButtonCancel = prop.getProperty("BUTTON_CANCEL");
			sName = prop.getProperty("LABEL_NAME");
			sDescription = prop.getProperty("LABEL_DESCRIPTION");
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) { // TODO : add message error if field is empty
		if(e.getSource() == accept){
			Limb limb = new Limb(nameValue.getText(), descriptionValue.getText());
			limb.saveToFile();
		}
		new AddLimb(parent);
		this.dispose();
		
	}

}
