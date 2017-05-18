

import java.io.FileNotFoundException;
import java.io.IOException;

public class decoder {
	 public static void main(String args[]) throws FileNotFoundException, IOException{
		 String encoded_file="";
		 String code_file="";
			if (0 < args.length) {
				encoded_file =args[0];
				code_file=args[1];
			}	
		decode(encoded_file,code_file);
		System.out.println("Decoding done successfully");
		} 
	
	 public static void decode(String encode_file,String code) throws NumberFormatException, IOException{
    	 Decode_Tree dt=new Decode_Tree();
		 dt.buildDecoderTree(dt.buildMapFromTable(code),encode_file);
    }
   
}
