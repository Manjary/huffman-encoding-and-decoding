package ADS;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.text.html.parser.DTD;

public class Main_Class {
   // static String[] symbolTable = new String[11111111];
	static HashMap<Integer, String> hmap_symbol=new HashMap<Integer, String>();
	public static void main( String args[]) throws IOException{

	
	  //  Binary_Min_Heap();
	    // print_symbol(hmap_symbol);
	   // DHeap();
	   // PairHeap();
	   DHeap_Final();
	  
   }

	public static void Binary_Min_Heap() throws FileNotFoundException, IOException{
		Huffman_Binary_Heap huffman=new Huffman_Binary_Heap();
		HashMap<Integer, Integer> hmap=huffman.getFrequencies("sample_input_small.txt");
		/*for (Integer key : hmap.keySet()) {
		    System.out.println(key + " " + hmap.get(key));
		}*/
		long startTime=System.currentTimeMillis();
		long endTime=0;
		for(int i=1; i<=10; i++ )
		{   // startTime = System.currentTimeMillis();
			BinaryMinHeap minHeap=huffman.generateTree(hmap);
			 	
		}
		endTime = System.currentTimeMillis();
		System.out.println("Time to Generate Binary Min Heap  tree --"+(endTime - startTime)*100);
		
		
		BinaryMinHeap minHeap=huffman.generateTree(hmap);
	    BinaryNode[] h=minHeap.getHeap();
	    /*System.out.println("generating tree starts");
	    System.out.println(h[1].getLeft().getFreq());
        System.out.println(h[1].getRight().getFreq());

        System.out.println(h[1].getLeft().getLeft().getFreq());
        System.out.println(h[1].getLeft().getRight().getFreq());

        System.out.println(h[1].getLeft().getLeft().getLeft().getFreq());
        System.out.println(h[1].getLeft().getLeft().getRight().getFreq());

        System.out.println(h[1].getRight().getLeft().getFreq());
        System.out.println(h[1].getRight().getRight().getFreq());

        System.out.println(h[1].getRight().getRight().getLeft().getFreq());
        System.out.println(h[1].getRight().getRight().getRight().getFreq());
        System.out.println("generating tree ends");
        
        
*/       // generateCode_BinaryHeap(minHeap.getMin(), ""); 
		//huffman.printHeap();
		}
	public static void DHeap()  throws FileNotFoundException, IOException{
		Huffman_DHeap huffman=new Huffman_DHeap();
		HashMap<Integer, Integer> hmap=huffman.getFrequencies("sample_input_small.txt");
		long startTime=System.currentTimeMillis();
		long endTime=0;
		for(int i=1; i<=10; i++ )
		{   // startTime = System.currentTimeMillis();
			DHeap dHeap=huffman.createHeap(hmap);
			dHeap=huffman.createTree(dHeap);	
		}
		endTime = System.currentTimeMillis();
		System.out.println("Time to Generate 4way  Heap  tree --"+(endTime - startTime)*100);
		
		DHeap dHeap=huffman.createHeap(hmap);
		
		
		
		//huffman.printHeap(dHeap);
	/*	while(dHeap.size()!=0){
		dHeap.delete_Min();
		System.out.println("Deleting------- heap size"+dHeap.size());
		huffman.printHeap(dHeap);
		}
	*/	
		//System.out.println("Creating------- heap size"+dHeap.size());
		dHeap=huffman.createTree(dHeap);
		DHeapNode[] h = dHeap.getHeap();
		
		//huffman.printHeap(dHeap);
/*		System.out.println(h[1].getFreq());
		System.out.println(h[1].getLeft_child().getFreq());
        System.out.println(h[1].getRight_child().getFreq());

        System.out.println(h[1].getLeft_child().getLeft_child().getFreq());
        System.out.println(h[1].getLeft_child().getRight_child().getFreq());
*/
//        System.out.println(h[1].getLeft_child().getLeft_child().getLeft_child().getFreq());
//        System.out.println(h[1].getLeft_child().getLeft_child().getRight_child().getFreq());

/*        System.out.println(h[1].getRight_child().getLeft_child().getFreq());
        System.out.println(h[1].getRight_child().getRight_child().getFreq());

        System.out.println(h[1].getRight_child().getRight_child().getLeft_child().getFreq());
        System.out.println(h[1].getRight_child().getRight_child().getRight_child().getFreq());
        System.out.println(h[1].getRight_child().getRight_child().getRight_child().getLeft_child().getFreq());
        System.out.println(h[1].getRight_child().getRight_child().getRight_child().getRight_child().getFreq());
*/	}
	
	public static void PairHeap()  throws FileNotFoundException, IOException{
		Huffman_PairHeap huffman=new Huffman_PairHeap();
		HashMap<Integer, Integer> hmap=huffman.getFrequencies("sample_input_small.txt");
		
		/*long endTime=0;
		for(int i=1; i<=10; i++ )
		{   // startTime = System.currentTimeMillis();
			System.out.println("step number" +i );
			PairHeap pairHeap=huffman.createHeap_Tree(hmap);
		}
		endTime = System.currentTimeMillis();
		System.out.println("Time to Generate Pair Heap  tree --"+(endTime - startTime)*100);
		*/
		long startTime = System.currentTimeMillis();
		for(int i=1; i<=10; i++ )
		{   // startTime = System.currentTimeMillis();
		    //	System.out.println("step number" +i );
			PairHeap pairHeap=huffman.createHeap_Tree(hmap);
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("Time to Generate Pair Heap  tree --"+(endTime - startTime)*100);
		/*System.out.println(pairHeap.getRoot().getElement());
		System.out.println(pairHeap.getRoot().gethLeftChild().getElement());
		System.out.println(pairHeap.getRoot().gethRightChild().getElement());
		System.out.println(pairHeap.getRoot().gethLeftChild().gethLeftChild().getElement());
		System.out.println(pairHeap.getRoot().gethLeftChild().gethRightChild().getElement());
		System.out.println(pairHeap.getRoot().gethRightChild().gethLeftChild().getElement());
		System.out.println(pairHeap.getRoot().gethRightChild().gethRightChild().getElement());
		System.out.println(pairHeap.getRoot().gethRightChild().gethRightChild().gethLeftChild().getElement());
		System.out.println(pairHeap.getRoot().gethRightChild().gethRightChild().gethRightChild().getElement());
		System.out.println(pairHeap.getRoot().gethRightChild().gethRightChild().gethRightChild().gethRightChild().getElement());
		System.out.println(pairHeap.getRoot().gethRightChild().gethRightChild().gethRightChild().gethLeftChild().getElement());
		//System.out.println(pairHeap.getRoot().gethRightChild().gethRightChild().gethRightChild().gethLeftChild().getElement());
		
	//	System.out.println(pairHeap.getRoot().gethRightChild().getElement());
//		System.out.println(pairHeap.getRoot().gethRightChild().getElement());
*/		
		
		//huffman.printHeap(pairHeap);
	}
	
    private static void generateCode_DHeap(DHeapNode node, String code) {             
        if(node != null) {                      
                if(node.isLeaf()){
                	   
                        hmap_symbol.put(node.getKey(),code);
                }
                //[node.getKey()] = code;
                else {
                	generateCode_DHeap(node.getLeft_child(), code + "0");
                	generateCode_DHeap(node.getRight_child(), code + "1");
                }
        }
        
       
    }
		

   private static void write_to_file_symbol(HashMap<Integer, String> hmap_symbol2) throws IOException{
	   Iterator it = hmap_symbol2.entrySet().iterator();
	   System.out.println("The size of the"+hmap_symbol2.size());
	   FileWriter fstream;
	    BufferedWriter out;

	    // create your filewriter and bufferedreader
	    fstream = new FileWriter("code.txt");
	    out = new BufferedWriter(fstream);
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        //System.out.println(pair.getKey() + " = " + pair.getValue());
	        out.write(pair.getKey()+" "+pair.getValue());
	        if(it.hasNext()){
	        out.newLine();
	        }
	       // it.remove(); // avoids a ConcurrentModificationException
	    }
	    out.close();
  }
   
   
	public static void DHeap_Final()  throws FileNotFoundException, IOException{
		Huffman_DHeap huffman=new Huffman_DHeap();
		HashMap<Integer, Integer> hmap=huffman.getFrequencies("sample_input_small.txt");
			
		DHeap dHeap=huffman.createHeap(hmap);
		dHeap=huffman.createTree(dHeap);
		generateCode_DHeap(dHeap.getMin(), "");
		write_to_file_symbol(hmap_symbol);
		encode_data("sample_input_small.txt","code.txt");
		
		}
	
   public static void encode_data(String input ,String code) throws IOException{
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
	    fstream = new FileOutputStream("C:/Projects/ADS/ADS_PROJECT/encode.bin");
	    out = new BufferedOutputStream(fstream);
    	String line_input="";
    	String encode_output="";
	     while((line_input=(input_file.readLine()))!=null){
	    	 if (map.containsKey(Integer.parseInt(line_input))) {
	    		 encode_output=encode_output+(map.get(Integer.parseInt(line_input)).toString());
	    	    }
	    	  if((encode_output.length()%8)==0){
	    		  BitSet bitSet=new BitSet(encode_output.length());
	    		    for(int i=0; i<encode_output.length();i++){
			    		if(encode_output.charAt(i)=='1'){
			    			bitSet.set(i);
			    		}
			    	}
			    	out.write(bitSet.toByteArray());
			    	encode_output="";
	    	  }  
	    	 
	          }
	      
	     BitSet bitSet=new BitSet(encode_output.length());
		    for(int i=0; i<encode_output.length();i++){
	    		if(encode_output.charAt(i)=='1'){
	    			bitSet.set(i);
	    		}
	    	}        
	    out.write(bitSet.toByteArray());
		out.close();
		
	  Decode_Tree dt=new Decode_Tree();
	  dt.buildDecoderTree(map);
	 }
   

 
 
}

