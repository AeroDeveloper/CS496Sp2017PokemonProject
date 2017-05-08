package objects;

import java.util.List;

public class Pokemon {
	private String name;
	private String type1, type2;
	private int hp, atk, def, spAtk, spDef, speed;

	
	public Pokemon(String name, String type1, String type2, int hp, int atk, int def, int spAtk, int spDef, int speed){
		this.name = name;

		this.type1 = type1;
		this.type2 = type2;
		this.hp = hp;
		this.atk = atk;
		this.def = def;
		this.spAtk = spAtk;
		this.spDef = spDef;
		this.speed = speed;
		
	}
	
	public String getType1(){}
	public String getType2(){}
	public int getHp(){}
	public int getAtk(){}
	public int getDef(){}
	public int getSpAtk(){}
	public int getSpDef(){}
	public int getSpeed(){}
	
}
