package objects;


public class Pokemon implements Comparable<Pokemon> {
	private String name;
	private String type1, type2;
	private int id, hp, atk, def, spAtk, spDef, speed;
	private int cv1 = 1;
	private int cv2 = 1;
	private int cvTotal = 1;
	
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
		this.cv1 = 1;
		this.cv2 = 1;
		this.cvTotal = 1;
		
	}
	
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
	
	public int getCv1(){return this.cv1;}
	public int getCv2(){return this.cv2;}
	public int getCvTotal{return this.cvTotal;}
	
	public void setCv1(int cv){this.cv1 = cv;}
	public void setCv2(int cv){this.cv2 = cv;}
	public void.setCvTotal)int cv){this.cvTotal = cv;}
	
	
	
	public int compareTo(String name) {
		return ((this.getName()).compareTo(name));
	}

	
	
	@Override
	public int compareTo(String inquiryName) {

		return (this.getName).compareTo(inquiryName);

	}
	
	
}
