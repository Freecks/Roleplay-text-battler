package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Equipment {

	public static final int TYPE_WEAPON = 0;
	public static final int TYPE_ARMOR = 1;
	public static final int TYPE_ACCESSORY = 2;
	
	private String name;
	private String description;
	private int type;	//is this a weapon, armor or accessory
	private int numberOfLimbs; // How many limbs do you need to handle this
	
	public Equipment(String name, String description, int type, int numberOfLimbs){
		this.name = name;
		this.description = description;
		this.type = type;
		this.numberOfLimbs = numberOfLimbs;
	}
	
	public boolean saveToFile(){
		
		Properties prop = new Properties();
		OutputStream output = null;
		File file = new File("equipments/" + name + ".properties");
		if(!file.exists()){
			try {
				output = new FileOutputStream("equipments/" + name + ".properties");
				prop.setProperty("name", name);
				prop.setProperty("description", description);
				prop.setProperty("type", "" + type);
				prop.setProperty("numberOfLimbs", "" + numberOfLimbs);
				prop.store(output, null);
				output.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}	
		return false;
	}
}
