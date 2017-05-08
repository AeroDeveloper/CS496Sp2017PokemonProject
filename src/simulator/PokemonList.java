package simulator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import objects.PokeMove;
import objects.Pokemon;

public class PokemonList implements Comparable<Pokemon>{
	List<Pokemon> result = new ArrayList<Pokemon>();
	
	public PokemonList(String path) throws FileNotFoundException, IOException, NumberFormatException, IllegalArgumentException{
		try{
			 this.result = buildPokemonList(readFile(path));
		} catch (IOException|IllegalArgumentException e){
			throw e;
		}
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

		} catch (IOException e) {
			throw e;
		}
		return rawData;
	}

	private List<Pokemon> buildPokemonList(List<String> rawDataList) throws NumberFormatException, IllegalArgumentException{
		List<Pokemon> pokeList = new ArrayList<Pokemon>();

		int atk,def,spAtk,spDef,aglty;//TODO Implement: id(?), index, hp(?)
		String name, type1,type2;//TODO Implement: ability1(?), ability2(?), abilityH(?)

		for(String currLine : rawDataList){

			String[] tokens = currLine.split(",");

			if((name = tokens[2]) == null)
				throw new IllegalArgumentException("Name not in current entry");

//			try{//FIXME Do we need this?
//				id = Integer.parseInt(tokens[0]);
//			} catch(NumberFormatException e){
//				throw new NumberFormatException("ID parse fail for " + name);
//			}

//			try{//FIXME
//				index = Integer.parseInt(tokens[1]);
//			} catch(NumberFormatException e){
//				throw new NumberFormatException("Index parse fail for " + name);
//			}

			if((type[0] = tokens[4]) == null)
				throw new IllegalArgumentException("Type parse fail for" + name);


			if((tokens[5]).isEmpty())//May not have second type
				type[1]= null;
			else
				type[1]= tokens[5];

//			if((ability1 = tokens[6]) == null) FIXME: Do we need these?
//				throw new IllegalArgumentException("Ability parse fail for" + name);
//
//			if(!((tokens[7]).isEmpty()))
//				ability2 = tokens[7];
//
//
//			if(!((tokens[8]).isEmpty()))
//				abilityH = tokens[8];

//			try{//FIXME
//				hp = Integer.parseInt(tokens[9]);
//			} catch(NumberFormatException e){
//				throw new NumberFormatException("HP parse fail for " + name);
//			}

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
				aglty = Integer.parseInt(tokens[14]);
			} catch(NumberFormatException e){
				throw new NumberFormatException("SPD spec parse fail for " + name);
			}
			List<PokeMove> pokeMoveList= null;//FIXME FOR TESTING
			Pokemon currPokemon = new Pokemon(name,type,atk,def,spAtk,spDef,aglty,1,pokeMoveList);//FIXME: FOR TESTING
			//Pokemon currPokemon = new Pokemon(id,index,name,type1,type2,ability1,ability2,abilityH,hp,atk,def,spAtk,spDef,spd);
			pokeList.add(currPokemon);
		}
		return pokeList;
	}
	
	public Pokemon searchByName(String name){
		for(Pokemon current : this.result){
			if((current.name).compareTo(name) == 0)//TODO implement getters and setters in pokemon object class
				return current;
		}
		return null;//FIXME
	}

	@Override
	public int compareTo(Pokemon o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
