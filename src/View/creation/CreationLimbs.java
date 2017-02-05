package View.creation;

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
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.Limb;

public class CreationLimbs extends JPanel implements ActionListener{

	public List<LimbBox> limbs;
	public JButton add;
	
	public String sButtonAdd;
	
	public CreationLimbs(){
		super();
		
		initString();
		
		this.setLayout(new GridBagLayout());
		limbs = new ArrayList<LimbBox>();
		add = new JButton(sButtonAdd);
		add.addActionListener(this);
		initLayout();
		/*GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.anchor = GridBagConstraints.WEST;
		c.insets = new Insets(0,5,0,0);
		this.add(add,c);*/
		
		
	}
	
	
	
	private void initLayout() {
		this.removeAll();
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.weightx = 1;
		c.ipady = 100;
		c.anchor = GridBagConstraints.NORTH;
		
		for(int i = 0; i<limbs.size(); i++){
			this.add(limbs.get(i),c);
		}
		c.fill = GridBagConstraints.NONE;
		c.weightx = 0;
		c.ipady = 0;
		c.gridx = 0;
		c.anchor = GridBagConstraints.WEST;
		c.insets = new Insets(0,5,5,0);
		this.add(add,c);
	}
	
	public void addLimb(String file){
		Properties prop = new Properties();
		InputStream input = null;
		try{
			input = new FileInputStream("limbs/" + file + ".properties");
			prop.load(input);
			limbs.add(new LimbBox(prop.getProperty("name"), prop.getProperty("description")));
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		initLayout();
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
			sButtonAdd = prop.getProperty("LIMBS_ADD");
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == add){
			new AddLimb(this);
			return;
		}
		for(int i = 0; i< limbs.size();i++){
			if(e.getSource() == limbs.get(i).getSuppr()){
				limbs.remove(i);
				this.remove(i);
				this.revalidate();
				this.repaint();
			}
		}
		
		
	}

}
