package simulator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import objects.Pokemon;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PokeCheck {

	public static void main(String[] args) {
		String path = "../Data/Gen1Pokemon.csv";
		try{
			new PokeCheck(path);
		}		catch (FileNotFoundException e)	{
			e.printStackTrace();//TODO	
		}		catch(IOException e){
			e.printStackTrace();//TODO
		}

	}

	public PokeCheck(String path) throws FileNotFoundException, IOException, NumberFormatException{
		List<Pokemon> listPokemon = buildPokemonList(readFile(path));
		//TODO
	}

	private List<String>readFile(String Path)throws FileNotFoundException, IOException{
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

		} catch (FileNotFoundException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		}
		return rawData;
	}

	private List<Pokemon> buildPokemonList(List<String> rawDataList) throws NumberFormatException, IllegalArgumentException{
		List<Pokemon> pokeList = new ArrayList<Pokemon>();

		int id, index,hp,atk,def,spAtk,spDef,spd;
		String name, type1, type2, ability1, ability2, abilityH;

		for(String currLine : rawDataList){

			String[] tokens = currLine.split(",");

			if((name = tokens[2]) == null)
				throw new IllegalArgumentException("Name not in current entry");//TODO find out what "forme" from the data file header means

			try{
				id = Integer.parseInt(tokens[0]);
			} catch(NumberFormatException e){
				throw new NumberFormatException("ID parse fail for " + name);
			}

			try{
				index = Integer.parseInt(tokens[1]);
			} catch(NumberFormatException e){
				throw new NumberFormatException("Index parse fail for " + name);
			}

			if((type1 = tokens[4]) == null)
				throw new IllegalArgumentException("Type parse fail for" + name);


			if(!((tokens[5]).isEmpty()))//May not have second type
				type2 = tokens[5];

			if((ability1 = tokens[6]) == null)
				throw new IllegalArgumentException("Ability parse fail for" + name);

			if(!((tokens[7]).isEmpty()))
				ability2 = tokens[7];


			if(!((tokens[8]).isEmpty()))
				abilityH = tokens[8];

			try{
				hp = Integer.parseInt(tokens[9]);
			} catch(NumberFormatException e){
				throw new NumberFormatException("HP parse fail for " + name);
			}

			try{
				atk = Integer.parseInt(tokens[10]);
			} catch(NumberFormatException e){
				throw new NumberFormatException("ATK parse fail for " + name);
			}

			try{
				def = Integer.parseInt(tokens[11]);
			} catch(NumberFormatException e){
				throw new NumberFormatException("DEF parse fail for " + name);
			}

			try{
				spAtk = Integer.parseInt(tokens[12]);
			} catch(NumberFormatException e){
				throw new NumberFormatException("SP.ATK parse fail for " + name);
			}

			try{
				spDef = Integer.parseInt(tokens[13]);
			} catch(NumberFormatException e){
				throw new NumberFormatException("SP.DEF parse fail for " + name);
			}

			try{
				spd = Integer.parseInt(tokens[14]);
			} catch(NumberFormatException e){
				throw new NumberFormatException("SPD spec parse fail for " + name);
			}
			Pokemon currPokemon = new Pokemon(id,index,name,type1,type2,ability1,ability2,abilityH,hp,atk,def,spAtk,spDef,spd);
			pokeList.add(currPokemon);
		}
		return pokeList;
	}
}
