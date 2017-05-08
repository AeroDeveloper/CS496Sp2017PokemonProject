package simulator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PokeCheck {

	public static void main(String[] args) {
        new Assign1(args[0], args[1]);// pass both args in
        System.out.println("Complete!");

	}

	private List<String>getLinesFromFile(String Path)throws FileNotFoundException, IOException{
        List<String> rawData = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(Path));
            String curLine = br.readLine();//If file is correct, will read header

            if(curLine != null){//If file is empty we will find no header and will exit with no results
                curLine = br.readLine();//Header present, now load data on next line
            }

            while(curLine != null ){//until end of file, given found header
                rawData.add(curLine);//add line as string entry into rawData
                curLine = br.readLine();//read next line
            }

        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rawData;
    }
}
