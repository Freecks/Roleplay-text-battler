package model;

import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;

public class Character {

	private String name;
	private String bio;
	private ImageIcon image;
	private Map<String,Limb> limbs; // A char can have 2 left arms, they are sensibly similar, but need to be named differently (i.e "left arm 1", "left arm 2")
	private Map<String,Equipment> equipments; // A piece of equipment can be handled by multiple limbs, but a limb can handle only one equipment
	private List<Capacity> capacities;
}
