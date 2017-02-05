package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Limb {

	private String name;
	private String description;
	private boolean deployed;
	
	public Limb(String name, String description){
		this.name = name;
		this.description = description;
	}
	
	public boolean saveToFile(){
		
		Properties prop = new Properties();
		OutputStream output = null;
		File file = new File("limbs/" + name + ".properties");
		if(!file.exists()){
			try {
				output = new FileOutputStream("limbs/" + name + ".properties");
				prop.setProperty("name", name);
				prop.setProperty("description", description);
				prop.store(output, null);
				output.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}	
		return false;
	}
	
	public String getName(){
		return name;
	}
	
	public String getDescription(){
		return description;
	}
}
