package objects;

public class PokeMove{//Wraps move object to include pokemon level information
	Move move;
	int lvlLearned;
	boolean machineLearned;
	
	public PokeMove(Move move, int lvlLearned){
		this.move= move;
		this.lvlLearned = lvlLearned;
		machineLearned = false;
	}
	
	public PokeMove (Move move, boolean machineLearned){
		this.move = move;
		this.machineLearned = machineLearned;
	}
}