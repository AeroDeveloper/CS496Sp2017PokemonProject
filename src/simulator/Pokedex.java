package simulator;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import objects.Pokemon;

public class Pokedex {

	public static void main(String[] args) {
		
		//create Set List
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PokeGui frame = new PokeGui();
					frame.setMasterList(buildPokemonList(readFile("src/Data/Gen1Pokemon.csv")));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static List<String> readFile(String Path)throws FileNotFoundException, IOException{
		
		List<String> rawData = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(Path));
			String curLine = br.readLine();//If file is correct, will read header

			if(curLine == null){//If file is empty we will find no header and will exit with no results
				br.close();
				throw new FileNotFoundException("File is Empty");//Header present, now load data on next line
			}

			while((curLine = br.readLine()) != null ){//until end of file, given found header
				rawData.add(curLine);//add line as string entry into rawData
			}
			br.close();

		} catch (IOException e) { throw e; }
		
		return rawData;
	}
	
	private static ArrayList<Pokemon> buildPokemonList(List<String> rawDataList) throws NumberFormatException, IllegalArgumentException{
		ArrayList<Pokemon> pokeList = new ArrayList<Pokemon>();
		int id,hp,atk,def,spAtk,spDef,spd;
		String name,type1,type2;

		for(String currLine : rawDataList){
			String[] tokens = currLine.split(",");

		try{ id = Integer.parseInt(tokens[0]);}
		catch(NumberFormatException e){ throw new NumberFormatException("ID parse fail for next entry");}	
		
			if((name = tokens[1]) == null)
				throw new IllegalArgumentException("Name parse for id" + Integer.toString(id));

			if((type1 = tokens[2]) == null)
				throw new IllegalArgumentException("Type parse fail for" + name);

			if((tokens[3]).isEmpty())//May not have second type
				type2= null;
			else
				type2 = tokens[3];

			try{ hp = Integer.parseInt(tokens[4]);
			} catch(NumberFormatException e){ throw new NumberFormatException("HP parse fail for " + name);	}
			
			try{ atk = Integer.parseInt(tokens[5]);} 
			catch(NumberFormatException e){	throw new NumberFormatException("ATK parse fail for " + name); }

			try{ def = Integer.parseInt(tokens[6]);	} 
			catch(NumberFormatException e){	throw new NumberFormatException("DEF parse fail for " + name); }

			try{ spAtk = Integer.parseInt(tokens[7]);} 
			catch(NumberFormatException e){	throw new NumberFormatException("SP.ATK parse fail for " + name); }

			try{ spDef = Integer.parseInt(tokens[8]); } 
			catch(NumberFormatException e){ throw new NumberFormatException("SP.DEF parse fail for " + name); }

			try{ spd = Integer.parseInt(tokens[9]); } 
			catch(NumberFormatException e){ throw new NumberFormatException("SPD spec parse fail for " + name);	}
			
			Pokemon currPokemon = new Pokemon(id, name, type1, type2, hp, atk, def,spAtk,spDef,spd);
			pokeList.add(currPokemon);
		}
		return pokeList;
	}
}
//TODO Add blank/default constructor for pokemon