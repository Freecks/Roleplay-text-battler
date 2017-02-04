package View.creation;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class CreationBio extends JPanel implements ActionListener{
	
	private JLabel nameL;
	private ImageIcon image;
	private JLabel imageL;
	private JButton imageB;
	private JLabel bioL;
	private JScrollPane bioP;
	private JTextField name;
	private JTextArea bio;
	private JFileChooser imageChooser;
	File imageFile;

	private String sNameL;
	private String sBioL;
	private String sButton;
	
	
	public CreationBio(){
		super();
		
		initString();
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		nameL = new JLabel(sNameL,SwingConstants.RIGHT);		
		image = new ImageIcon();
		imageL = new JLabel(image);
		imageB = new JButton(sButton);
		imageB.setPreferredSize(new Dimension(0,0));
		imageB.addActionListener(this);
		bioL = new JLabel(sBioL,SwingConstants.RIGHT);
		name = new JTextField();
		bio = new JTextArea();
		bio.setEditable(true);
		bio.setLineWrap(true);
		bioP = new JScrollPane(bio);
		bioP.setPreferredSize(new Dimension(0,0));
		imageChooser = new JFileChooser();
		imageChooser.addChoosableFileFilter(new ImageFilter());
		imageChooser.setAcceptAllFileFilterUsed(false);
		imageFile = null;
		
		c.gridx = 0;
		c.gridy = 0;
		c.weighty = 0.85;
		c.weightx = 0.2;
		c.gridheight = 2;
		c.fill = GridBagConstraints.BOTH;
		//c.insets = (new Insets(10, 10, 10, 0));
		this.add(imageL,c);
		c.gridy = 2;
		c.weighty = 0.15;
		c.insets = (new Insets(10, 10, 10, 0));
		this.add(imageB,c);
		c.gridheight = 1;
		c.gridx++;
		c.gridy = 0;
		c.weightx = 0.05;
		c.weighty = 0.1;
		c.insets = (new Insets(10, 0, 10, 5));
		this.add(nameL,c);
		c.gridx++;
		c.weightx = 0.75;
		c.insets = (new Insets(10, 5, 10, 10));
		this.add(name,c);
		c.gridx--;
		c.gridy++;
		c.weightx = 0.05;
		c.weighty = 0.9;
		c.ipady = 15;
		c.anchor = GridBagConstraints.NORTH;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = (new Insets(10, 0, 10, 5));
		this.add(bioL,c);
		c.gridx++;
		c.ipady = 0;
		c.weightx = 0.75;
		c.fill = GridBagConstraints.BOTH;
		c.insets = (new Insets(10, 5, 10, 10));
		this.add(bioP,c);
		
		
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
			sNameL = prop.getProperty("LABEL_NAME");
			sBioL = prop.getProperty("LABEL_BIO");
			sButton = prop.getProperty("LABEL_BUTTON_IMAGE");
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == imageB){
			int returnVal = imageChooser.showOpenDialog(this.getParent());
			if (returnVal == JFileChooser.APPROVE_OPTION) {
	            File file = imageChooser.getSelectedFile();
	            imageFile = file;
			    setImage();
			            
			}
		}
	}
	
	public void setImage(){	
		BufferedImage bi = null;
        try {
        	bi = ImageIO.read(imageFile);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
        ImageIcon imageTemp = new ImageIcon(bi);
        
		int h = imageL.getHeight(), w = imageL.getWidth();
		int nw = imageTemp.getIconWidth();
        int nh = imageTemp.getIconHeight();
		
		if(imageTemp.getIconWidth() > w)
        {
          nw = w;
          nh = (nw * imageTemp.getIconHeight()) / imageTemp.getIconWidth();
        }

        if(nh > h)
        {
          nh = h;
          nw = (imageTemp.getIconWidth() * nh) / imageTemp.getIconHeight();
        }
	    
	    image.setImage(imageTemp.getImage().getScaledInstance(nw, nh, Image.SCALE_DEFAULT));
	    imageL.setIcon(image);
	    imageL.setPreferredSize(new Dimension(0,0));
	    
        this.revalidate();
        this.repaint();  
	}
	
}
