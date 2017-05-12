package objects;

public class Pokemon implements Comparable<Pokemon> {
	private String name;
	private int id, hp, atk, def, spAtk, spDef, speed;
	private PokeType type1, type2;
	
	//Default constructor class
	public Pokemon(){
		this.id = -1;
		this.name = null;
		this.hp = -1;
		this.atk = -1;
		this.def = -1;
		this.spAtk = -1;
		this.spDef = -1;
		this.speed = -1;
		this.type1 = new PokeType(null);
		this.type2 = new PokeType(null);
	}

	public Pokemon(int id, String name, String type1, String type2, int hp, int atk, int def, int spAtk, int spDef, int speed){
		this.id = id;
		this.name = name;
		this.hp = hp;
		this.atk = atk;
		this.def = def;
		this.spAtk = spAtk;
		this.spDef = spDef;
		this.speed = speed;
		this.type1 = new PokeType(type1);
		this.type2 = new PokeType(type2);
	}

	//Getters
	public Pokemon(String name){ this.name = name; }
	public int getId(){ return this.id; }
	public String getName(){ return this.name; }
	public PokeType getType1(){ return this.type1; }
	public PokeType getType2(){ return this.type2; }
	public int getHp(){ return this.hp; }
	public int getAtk(){ return this.atk; }
	public int getDef(){ return this.def; }
	public int getSpAtk(){ return this.spAtk; }
	public int getSpDef(){ return this.spDef; }
	public int getSpeed(){ return this.speed; }

	//To ensure that it inspects the name of the pokemon when trying to make comparisons
	@Override
	public int compareTo(Pokemon other) { return (((this.getName()).toUpperCase()).compareTo((other.getName()).toUpperCase())); }

	public boolean equals(Pokemon other){
		return((this.compareTo(other)) == 0);
	}

	//May not be needed
	@Override
	public String toString(){ return getName(); }
}
