package objects;

import java.util.List;

public class Combatant {
	int lvl;
	Pokemon pokemon;
	List<Move> attacks;
	
	public Combatant(Pokemon pokemon, int lvl){
		this.pokemon = pokemon;
		this.lvl = lvl;
		this.attacks = chooseMoves(pokemon, lvl);
	}
	
	public List<Move> chooseMoves(Pokemon pokemon,int lvl){//TODO
		if(pokemon.startLvl != 0){//If it evolves from something we need to get their move list
			return null;
		}
		return null;
	}
}
