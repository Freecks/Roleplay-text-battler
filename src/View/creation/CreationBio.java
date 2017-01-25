package View.creation;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class CreationBio extends JPanel{
	
	private JLabel nameL;
	private ImageIcon image;
	private JLabel imageL;
	private JLabel bioL;
	private JScrollPane bioP;
	private JTextField name;
	private JTextArea bio;

	
	public CreationBio(){
		super();
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		nameL = new JLabel("temp",SwingConstants.RIGHT);
		image = new ImageIcon();
		imageL = new JLabel(image);
		bioL = new JLabel("temp2",SwingConstants.RIGHT);
		name = new JTextField();
		bio = new JTextArea();
		bio.setEditable(true);
		//bio.setLineWrap(true);
		bioP = new JScrollPane(bio);
		
		c.gridx = 0;
		c.gridy = 0;
		c.weighty = 1;
		c.weightx = 0.2;
		c.gridheight = 2;
		c.fill = GridBagConstraints.BOTH;
		c.insets = (new Insets(10, 10, 10, 10));
		this.add(new JButton(""),c);
		c.gridheight = 1;
		c.gridx++;
		c.weightx = 0.1;
		c.weighty = 0.1;
		this.add(nameL,c);
		c.gridx++;
		c.weightx = 0.7;
		this.add(name,c);
		c.gridx--;
		c.gridy++;
		c.weightx = 0.1;
		c.weighty = 0.9;
		c.anchor = GridBagConstraints.NORTH;
		c.fill = GridBagConstraints.HORIZONTAL;
		this.add(bioL,c);
		c.gridx++;
		c.weightx = 0.7;
		c.fill = GridBagConstraints.BOTH;
		this.add(bioP,c);
		
	}
}
