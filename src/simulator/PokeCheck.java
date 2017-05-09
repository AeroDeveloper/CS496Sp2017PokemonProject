package simulator;


public class PokeCheck {

	public static void main(String[] args) {
		
		String path = "src/Data/Gen1Pokemon.csv";
		try {
			new PokeGui(new PokemonList(path));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
//TODO Add blank/default constructor for pokemon