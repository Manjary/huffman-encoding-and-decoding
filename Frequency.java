
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Frequency {

public HashMap<Integer,Integer> read_file(String filelocation)throws IOException,FileNotFoundException{
	BufferedReader br = null;
	FileReader fr = null;
    Integer One=1;
    HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
	try {

		fr = new FileReader(filelocation);
		br = new BufferedReader(fr);

		String sCurrentLine;

		br = new BufferedReader(new FileReader(filelocation));
		
		while (((sCurrentLine = br.readLine())!= null) && (sCurrentLine.length() > 0)) {
			
			 if (hmap.containsKey(Integer.parseInt(sCurrentLine))){
				 hmap.put(Integer.parseInt(sCurrentLine), hmap.get(Integer.parseInt(sCurrentLine))+1);
				 }
			 else
			 {
				 hmap.put(Integer.parseInt(sCurrentLine),One);
			 }
		}
	/*	for (Integer key : hmap.keySet()) {
		    System.out.println(key + " " + hmap.get(key));
		}*/
	} catch (IOException e) {

		e.printStackTrace();

	} finally {
       try {

			if (br != null)
				br.close();

			if (fr != null)
				fr.close();

		} catch (IOException ex) {

			ex.printStackTrace();

		}
	}
	return hmap;
}

public static void main( String args[]) throws IOException{
	Frequency f=new Frequency();
	String fileLocation="sample_input_small.txt";
	f.read_file(fileLocation);
	
}
}


