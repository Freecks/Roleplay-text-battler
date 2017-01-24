package View;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import lang.EN_en;

public class Creation extends JFrame implements ActionListener{

	private JPanel frame;
	private JList listChar;
	private JPanel bio;
	private JTabbedPane parts;
	private JPanel limbs;
	private JPanel equipments;
	private JPanel capacities;
	private JButton back;
	
	public Creation(){
		super();
		
		initString();
		
		frame = new JPanel();
		frame.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		listChar = new JList();
		bio = new JPanel();
		parts = new JTabbedPane();
		back = new JButton("<-");
		limbs = new CreationLimbs();
		equipments = new CreationEquipments();
		capacities = new CreationCapacities();
		
		parts.add(capacities, "temp1");
		parts.add(limbs, "temp2");
		parts.add(equipments, "temp3");
		
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
		Dimension screenSize = new Dimension(1000,800);
		this.setSize(screenSize);
		this.setTitle(EN_en.DEFAULT);
		this.setMinimumSize(new Dimension(200,275));
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		
	}
	
	
	
	private void initString() {
		
		
	}



	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
