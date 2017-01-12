package model;

public class Effect {
	
	public static final int TYPE_DAMAGES=0;
	public static final int TYPE_HEALING=1;
	public static final int TYPE_SUMMON=2;
	public static final int TYPE_ILLUSION=3;
	public static final int TYPE_OBSTACLE=4;
	public static final int TYPE_TRANSFORMATION=5;
	public static final int TYPE_MOVEMENT=6;
	public static final int TYPE_EQUIPMENT=7;
	
	public static final int TARGET_ENNEMY=0;
	public static final int TARGET_SELF=1;
	
	public static final int SHAPE_GROUND=0;
	public static final int SHAPE_AIR=1;
	public static final int SHAPE_GROUND_AOE=2;
	public static final int SHAPE_AIR_AOE=3;
	
	public static final int ORIGIN_SELF=0;
	public static final int ORIGIN_CLOSE=1;
	public static final int ORIGIN_MEDIUM=2;
	public static final int ORIGIN_FAR=3;
	
	public static final int RANGE_VERY_CLOSE=0;
	public static final int RANGE_CLOSE=1;
	public static final int RANGE_MEDIUM=2;
	public static final int RANGE_FAR=3;
	
	
	
	private int randomValue;
	private int type;
	private int target;
	private int shape;
	private int origin;
	private int range;
	private int duration;
	private int delay;
	
}
