package simulator;


public class PokeCheck {

	public static void main(String[] args) {
		
		String path = "src/Data/Gen1Pokemon.csv";
		try{
		PokemonList pokeList = new PokemonList(path);
		new PokeGui(pokeList);
		} catch (Exception e)	{
			e.printStackTrace();//TODO	
		}
	}
}
//TODO Add blank/default constructor for pokemon