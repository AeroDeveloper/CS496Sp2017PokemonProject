package objects;

public class Pokemon {
	String name;
	String[] type;
	int atk, def, spAtk, spDef, aglty;
	
	public Pokemon(String name, String[] type, int atk, int def, int spAtk, int spDef, int aglty){
		this.name = name;
		this.type = type;
		this.atk = atk;
		this.def = def;
		this.spAtk = spAtk;
		this.spDef = spDef;
		this.aglty = aglty;
	}
	

}
