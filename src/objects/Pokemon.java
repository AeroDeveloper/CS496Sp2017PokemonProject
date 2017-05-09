package objects;


public class Pokemon implements Comparable<Pokemon> {
	private String name;
	private String type1, type2;
	private int id, hp, atk, def, spAtk, spDef, speed;


	public Pokemon(int id, String name, String type1, String type2, int hp, int atk, int def, int spAtk, int spDef, int speed){
		this.id = id;
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

	public Pokemon(String name){ this.name = name; }
	public int getId(){ return this.id; }
	public String getName(){ return this.name; }
	public String getType1(){ return this.type1; }
	public String getType2(){ return this.type2; }
	public int getHp(){ return this.hp; }
	public int getAtk(){ return this.atk; }
	public int getDef(){ return this.def; }
	public int getSpAtk(){ return this.spAtk; }
	public int getSpDef(){ return this.spDef; }
	public int getSpeed(){ return this.speed; }

	@Override
	public int compareTo(Pokemon other) { return (this.getName()).compareTo(other.getName()); }
	
	@Override
	public String toString(){ return getName(); }

}
