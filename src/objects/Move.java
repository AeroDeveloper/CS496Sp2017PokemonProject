package objects;

public class Move {
	//Base
	String moveName, moveType, moveCategory;
	int pow, acc, pp;
	String target;//combatant, opponent, or "both"
	
	//Variant I Only stats affected (i.e. attack, def, etc)
	String[] affectedStat;//if affects both, put opponent stat name first, then combatant
	String[] statChange;//if affects both, put opponent stat change first, then combatant
	
	
	//Variant II, only a status condition inflicted (i.e. status category)
	String condition;
	
	//Variant III attack move with specific effects
	String[] effect;
	
	//Template, use as basis
	public Move(String moveName, String moveType, String moveCategory, int pow, int acc, int pp, String target){
		this.moveName = moveName;
		this.moveCategory = moveCategory;
		this.moveType = moveType;
		
		this.pow = pow;//status category has no power
		this.acc = acc;
		this.pp = pp;
		
		this.target = target;
	}
	
	//Var I  Status is raised or lowered
	public Move(String moveName, String moveType, String moveCategory, int pow, int acc, int pp, String target, String[] affectedStat, String[] statChange){
		this.moveName = moveName;
		this.moveCategory = moveCategory;
		this.moveType = moveType;
		
		this.pow = pow;//status category has no power
		this.acc = acc;
		this.pp = pp;
		
		this.target = target;
		
		this.affectedStat = affectedStat;
		this.statChange = statChange;
	}
	
	//Var II  Ailment or condition change (sleep, poison, etc)
	public Move(String moveName, String moveType, String moveCategory, int pow, int acc, int pp, String target, String condition){
		this.moveName = moveName;
		this.moveCategory = moveCategory;
		this.moveType = moveType;
		
		this.pow = pow;//status category has no power
		this.acc = acc;
		this.pp = pp;
		
		this.target = target;
		
		this.condition = condition;
	}
	
	
	//Var III Special Effects
	public Move(String moveName, String moveType, String moveCategory, int pow, int acc, int pp, String target, String[] effect){
		this.moveName = moveName;
		this.moveCategory = moveCategory;
		this.moveType = moveType;
		
		this.pow = pow;//status category has no power
		this.acc = acc;
		this.pp = pp;
		
		this.target = target;
		
		this.effect = effect;
	}
}
