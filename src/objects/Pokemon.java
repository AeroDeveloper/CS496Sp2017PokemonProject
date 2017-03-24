package objects;

import java.util.List;

public class Pokemon {
	String name;
	String[] type;
	int atk, def, spAtk, spDef, aglty;//TODO Determine if Static
	int gen;
	int startLvl;
	Pokemon prevEvo;
	List<PokeMove> allMoves;//TODO Will contain moves specific to this Pokemon (not evolutionary predecessors) 
	
	
	//No Evolutions
	public Pokemon(String name, String[] type, int atk, int def, int spAtk, int spDef, int aglty,int gen, List<PokeMove> allMoves){
		this.name = name;
		this.gen = gen;
		
		this.type = type;
		this.atk = atk;
		this.def = def;
		this.spAtk = spAtk;
		this.spDef = spDef;
		this.aglty = aglty;
		
		this.startLvl = 0;
		
		this.allMoves = allMoves;
	}
	
	//Has predecessor in evolution
	public Pokemon(String name, String[] type, int atk, int def, int spAtk, int spDef, int aglty,int gen, int startLvl, Pokemon prevEvo, List<PokeMove> allMoves){
		this.name = name;
		this.gen = gen;
		
		this.type = type;
		this.atk = atk;
		this.def = def;
		this.spAtk = spAtk;
		this.spDef = spDef;
		this.aglty = aglty;
		
		this.startLvl = startLvl;
		this.prevEvo = prevEvo;
		
		this.allMoves = allMoves;
	}
	
	

	

	
	
	

}
