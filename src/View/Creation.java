package View;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import View.creation.CreationBio;
import View.creation.CreationCapacities;
import View.creation.CreationEquipments;
import View.creation.CreationLimbs;
import lang.EN_en;
import lang.FR_fr;

public class Creation extends JFrame implements ActionListener{

	private JPanel frame;
	private JList listChar;
	private CreationBio bio;
	private JTabbedPane parts;
	private JPanel limbs;
	private JPanel equipments;
	private JPanel capacities;
	private JButton back;
	
	private String sTitle;
	private String sCapacities;
	private String sLimbs;
	private String sEquipments;
	
	public Creation(){
		super();
		
		initString();
		
		frame = new JPanel();
		frame.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		listChar = new JList();
		bio = new CreationBio();		
		frame.addComponentListener(new ComponentListener() {
		    public void componentResized(ComponentEvent e) {
		        bio.setImage();     
		    }

			@Override
			public void componentHidden(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentMoved(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentShown(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		parts = new JTabbedPane();
		back = new JButton("<-");
		back.addActionListener(this);
		limbs = new CreationLimbs();
		equipments = new CreationEquipments();
		capacities = new CreationCapacities();
		
		parts.add(capacities, sCapacities);
		parts.add(limbs, sLimbs);
		parts.add(equipments, sEquipments);
		
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.WEST;
		frame.add(back,c);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.25;
		c.weighty = 1;
		c.gridy = 1;
		c.gridheight = 2;
		frame.add(listChar,c);
		c.weightx = 0.75;
		c.weighty = 0.33;
		c.gridx = 1;
		c.gridheight = 1;
		frame.add(bio,c);
		c.gridy = 2;
		c.weighty = 0.67;
		frame.add(parts,c);
		
		
		this.setContentPane(frame);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension screenSize = new Dimension(1424,801);
		this.setSize(screenSize);
		this.setTitle(sTitle);
		this.setMinimumSize(new Dimension(480,270));
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		switch (language) {
		case "EN_en":
			sTitle = EN_en.TITLE;
			sCapacities = EN_en.TAB_CAPACITIES;
			sLimbs = EN_en.TAB_LIMBS;
			sEquipments = EN_en.TAB_EQUIPMENTS; 
			break;

		case "FR_fr":
			sTitle = FR_fr.TITLE;
			sCapacities = FR_fr.TAB_CAPACITIES;
			sLimbs = FR_fr.TAB_LIMBS;
			sEquipments = FR_fr.TAB_EQUIPMENTS; 
			break;
		default:
			break;
		}	
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == back){
			new Menu();
			this.dispose();
		}	
	}

}
