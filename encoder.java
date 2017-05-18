

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class encoder {
	static HashMap<Integer, String> hmap_symbol=new HashMap<Integer, String>();
	
	public static void main(String args[]) throws FileNotFoundException, IOException{
		String fileName="";
		if (0 < args.length) {
		     fileName =args[0];
		}	
	   FourWayHeap(fileName);	
	}
	public static void FourWayHeap(String input_file)  throws FileNotFoundException, IOException{
		Huffman_FourWayHeap huffman=new Huffman_FourWayHeap();
		HashMap<Integer, Integer> hmap=huffman.getFrequencies(input_file);
		FourWayHeap dHeap=huffman.createHeap(hmap);
		dHeap=huffman.createTree(dHeap);
		generateCode_FourwayHeap(dHeap.getMinNode(), "");
		write_to_file_symbol(hmap_symbol,"code_table.txt");
		encode_data(input_file,"code_table.txt","encoded.bin");
		System.out.println("Encoding is done.");
		
		}
	  public static void encode_data(String input ,String code, String encode_file) throws IOException{
		   HashMap<Integer, String> map = new HashMap<Integer, String>();
		   BufferedReader input_file = new BufferedReader(new FileReader(input));
		   BufferedReader code_file = new BufferedReader(new FileReader(code));
		   String line = "";
		   while ((line = code_file.readLine()) != null) {
	           String parts[] = line.split(" ");
	           map.put(Integer.parseInt(parts[0]), parts[1]);
	       }
		   code_file.close();
		   FileOutputStream fstream;
		   BufferedOutputStream out;

		    // create your filewriter and bufferedreader
		    fstream = new FileOutputStream(encode_file);
		    out = new BufferedOutputStream(fstream);
	    	String line_input="";
	    	String encode_output="";
		     while((line_input=(input_file.readLine()))!=null){
		    	 if (map.containsKey(Integer.parseInt(line_input))) {
		    		 encode_output=encode_output+(map.get(Integer.parseInt(line_input)).toString());
		    		 if(encode_output.length()%8 ==0){
			    		 for(int i=0; i<encode_output.length(); i+=8){
			    			 String byteString=encode_output.substring(i, i+8);
			    			 int byteValue= 0xFF & Integer.parseInt(byteString ,2);
			    			 out.write(byteValue);
			    		 }
			    		 encode_output="";
			    		// System.out.println("resetted encode_output");
			    		 }   
		    	 }
		    	 
		     }
		    	
		     for(int i=0; i<encode_output.length(); i+=8){
				 String byteString=encode_output.substring(i, i+8);
				 int byteValue= 0xFF & Integer.parseInt(byteString ,2);	
				 out.write(byteValue);
			 }		
		     out.close();
		    
	       }

	   private static void write_to_file_symbol(HashMap<Integer, String> hmap_symbol2,String filepath) throws IOException{
		   Iterator it = hmap_symbol2.entrySet().iterator();
		   //System.out.println("The size of the"+hmap_symbol2.size());
		   FileWriter fstream;
		    BufferedWriter out;
		    fstream = new FileWriter(filepath);
		    out = new BufferedWriter(fstream);
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        
		        out.write(pair.getKey()+" "+pair.getValue());
		        if(it.hasNext()){
		        out.newLine();
		        }
		      
		    }
		    out.close();
	  }	   
		
	    private static void generateCode_FourwayHeap(FourWayHeapNode node, String code) {             
	        if(node != null) {                      
	                if(node.isLeaf()){
	                	   
	                        hmap_symbol.put(node.getKey(),code);
	                }
	    
	                else {
	                	generateCode_FourwayHeap(node.getLeft_child(), code + "0");
	                	generateCode_FourwayHeap(node.getRight_child(), code + "1");
	                }
	        }
	        
	       
	    }
			


}
