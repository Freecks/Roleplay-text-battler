package View.creation;

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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class LimbBox extends JPanel implements ActionListener{

	private JLabel name;
	private JLabel nameValue;
	private JLabel type;
	private JLabel typeValue;
	private JLabel description;
	private JTextArea descriptionValue;
	private JScrollPane descriptionScroll;
	private JButton suppr;
	
	private String sName;
	private String sType;
	private String sDesc;
	
	public LimbBox(String name, String type, String description){
		super();
		
		initString();
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		this.name = new JLabel(sName,SwingConstants.RIGHT);
		nameValue = new JLabel(name);
		this.type = new JLabel(sType, SwingConstants.RIGHT);
		typeValue = new JLabel(type);
		this.description = new JLabel(sDesc, SwingConstants.RIGHT);
		descriptionValue = new JTextArea(description);
		descriptionValue.setLineWrap(true);
		descriptionValue.setEditable(false);
		descriptionScroll = new JScrollPane(descriptionValue);
		descriptionScroll.setPreferredSize(new Dimension(0,0));
		suppr = new JButton("X");
		suppr.addActionListener((ActionListener) this);
		
		
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(5,5,5,5);
		this.add(this.name,c);
		c.weightx = 1;
		c.gridx++;
		this.add(nameValue,c);
		c.gridx++;
		c.weightx = 0;
		this.add(this.type,c);
		c.gridx++;
		c.weightx = 1;
		this.add(typeValue,c);
		c.gridx = 0;
		c.gridy++;
		c.weighty = 1;
		c.weightx = 0;
		c.anchor = GridBagConstraints.NORTH;
		c.fill = GridBagConstraints.HORIZONTAL;
		this.add(this.description,c);
		c.gridx++;
		c.weightx = 0.95;
		c.gridwidth = 3;
		c.fill = GridBagConstraints.BOTH;
		this.add(descriptionScroll,c);
		c.gridwidth = 1;
		c.gridy--;
		c.gridx = 4;
		c.weightx = 0;
		c.weighty = 0;
		this.add(suppr,c);
		c.gridx = 0;
		c.gridwidth = 5;
		c.gridy = 3;
		this.add(new JSeparator(),c);
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
			sName = prop.getProperty("LABEL_NAME");
			sDesc = prop.getProperty("LABEL_DESCRIPTION");
			sType = prop.getProperty("LABEL_TYPE");
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public JButton getSuppr(){
		return suppr;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		((ActionListener) this.getParent()).actionPerformed(e);
	}
	
}
