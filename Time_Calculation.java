

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
public class Time_Calculation {
   
	static HashMap<Integer, String> hmap_symbol=new HashMap<Integer, String>();
	public static void main( String args[]) throws IOException{
		String fileName="";
		if (0 < args.length) {
		     fileName =args[0];
		}	
	
	   Binary_Min_Heap(fileName);
	   FourWayHeap(fileName);
	   PairHeap(fileName);
	  // DHeap_Final("sample_input_small.txt");
	 /*  encoder enocoder=new encoder();
	   encoder.DHeap_Final("sample_input_small.txt");*/
	  // decode("C:/Projects/ADS/ADS_PROJECT/encoded.bin","code_table.txt");
	  
   }

	public static void Binary_Min_Heap(String inputFile) throws FileNotFoundException, IOException{
		Huffman_Binary_Heap huffman=new Huffman_Binary_Heap();
		HashMap<Integer, Integer> hmap=huffman.getFrequencies(inputFile);
		long startTime=System.currentTimeMillis();
		long endTime=0;
		for(int i=1; i<=10; i++ )
		{ 
			BinaryMinHeap minHeap=huffman.generateTree(hmap);
			 	
		}
		endTime = System.currentTimeMillis();
		System.out.println("Time to Generate Binary Min Heap tree --"+(endTime - startTime)*100);
		BinaryMinHeap minHeap=huffman.generateTree(hmap);
	    BinaryNode[] h=minHeap.getHeap();
	    		}

	
  public static void FourWayHeap(String inputFile)  throws FileNotFoundException, IOException{
		Huffman_FourWayHeap huffman=new Huffman_FourWayHeap();
		HashMap<Integer, Integer> hmap=huffman.getFrequencies(inputFile);
		long startTime=System.currentTimeMillis();
		long endTime=0;
		for(int i=1; i<=10; i++ )
		{   
			FourWayHeap dHeap=huffman.createHeap(hmap);
			dHeap=huffman.createTree(dHeap);	
		}
		endTime = System.currentTimeMillis();
		System.out.println("Time to Generate 4way  Heap  tree --"+(endTime - startTime)*100);
		
		FourWayHeap dHeap=huffman.createHeap(hmap);
		
		dHeap=huffman.createTree(dHeap);
		FourWayHeapNode[] h = dHeap.getHeap();
		}
	
	public static void PairHeap(String inputFile)  throws FileNotFoundException, IOException{
		Huffman_PairHeap huffman=new Huffman_PairHeap();
		HashMap<Integer, Integer> hmap=huffman.getFrequencies(inputFile);
		long startTime = System.currentTimeMillis();
		for(int i=1; i<=10; i++ )
		{   // startTime = System.currentTimeMillis();
		    //	System.out.println("step number" +i );
			PairHeap pairHeap=huffman.createHeap_Tree(hmap);
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("Time to Generate Pair Heap  tree --"+(endTime - startTime)*100);
	}
	
    private static void generateCode_DHeap(FourWayHeapNode node, String code) {             
        if(node != null) {                      
                if(node.isLeaf()){
                	   
                        hmap_symbol.put(node.getKey(),code);
                }
    
                else {
                	generateCode_DHeap(node.getLeft_child(), code + "0");
                	generateCode_DHeap(node.getRight_child(), code + "1");
                }
        }
        
       
    }
		

   private static void write_to_file_symbol(HashMap<Integer, String> hmap_symbol2,String filepath) throws IOException{
	   Iterator it = hmap_symbol2.entrySet().iterator();
	   System.out.println("The size of the"+hmap_symbol2.size());
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
   
   
/*	public static void DHeap_Final(String input_file)  throws FileNotFoundException, IOException{
		Huffman_DHeap huffman=new Huffman_DHeap();
		HashMap<Integer, Integer> hmap=huffman.getFrequencies(input_file);
		DHeap dHeap=huffman.createHeap(hmap);
		dHeap=huffman.createTree(dHeap);
		generateCode_DHeap(dHeap.getMinNode(), "");
		write_to_file_symbol(hmap_symbol,"code_table.txt");
		encode_data(input_file,"code_table.txt","C:/Projects/ADS/ADS_PROJECT/encoded.bin");
		
		}*/
	
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
   
   /* public static void decode(String encode_file,String code) throws NumberFormatException, IOException{
    	 Decode_Tree dt=new Decode_Tree();
		 dt.buildDecoderTree(dt.buildMapFromTable(code),encode_file);
    }
   */
	 }
   

 
 


