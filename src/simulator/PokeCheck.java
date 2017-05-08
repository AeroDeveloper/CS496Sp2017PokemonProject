package simulator;

import java.io.IOException;
import java.io.FileNotFoundException;


public class PokeCheck {

	public static void main(String[] args) {

		try{
			new PokeGui();
		} catch (NullPointerException e)	{
			e.printStackTrace();//TODO	
		} catch (FileNotFoundException e)	{
			e.printStackTrace();//TODO	
		} catch(IOException e){
			e.printStackTrace();//TODO
		} catch(IllegalArgumentException e){
			e.printStackTrace();//TODO
		}
	}
}
