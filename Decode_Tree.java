

import java.io.BufferedInputStream;
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

public class Decode_Tree {
	private int size = 0;
    private Node root=new Node(null,-1);
	public int size(){
	   return size;
	}
	
	public void buildDecoderTree(HashMap<Integer,String> hmap, String encoded_file) throws IOException{
		Iterator<Integer> it=hmap.keySet().iterator();
		while(it.hasNext()){
			int key=it.next();
			String code=hmap.get(key);
			buildTree(code,key);
			//buildTree("0010101",1212121);
			
		}
		
			byte[] message=	readBinaryFile(encoded_file);
			 StringBuilder binary = new StringBuilder();
			 String res="";
			 FileWriter fstream;
		
					fstream = new FileWriter("decoded.txt");
					BufferedWriter out;
					out = new BufferedWriter(fstream);
		     	 for(int i=0;i<message.length;i++){
		        	//System.out.println(buffer[i]);
		        	int x=message[i] & 0xFF;
		        	//System.out.println(x+": "+Integer.toBinaryString(x));
		        	String s1 = String.format("%08d", Integer.parseInt(Integer.toBinaryString(x)));
		        //	System.out.println(s1);
		        	res=decodeMessageUsingTree(root, res+s1, out);	
		     	 }  
		out.close();
	}
	
	public void buildTree(String code,int value){
		Node temp =root;
		char[] ch=code.toCharArray();
    	   for (int i=0; i<ch.length; i++){
    		   if(ch[i] =='0'){
    			   if(temp.left == null){
    				   temp.left=new Node("0",-1);
    				   temp=temp.left;
    			   }
    			   else{
    				   temp=temp.left;
    			   }
    			   }
    		   else if(ch[i]=='1'){
    			   if(temp.right == null){
    				   temp.right=new Node("1",-1);
    				   temp=temp.right;
    			   }
    			   else{
    				   temp=temp.right;
    			   }
    			   
    		   }   
    			   }
    	       temp.code=code;
    	       temp.value=value;
          
    		   }
	public byte[] readBinaryFile(String filePath) throws IOException{
		File binaryfile = new File(filePath);
		InputStream binaryis = new BufferedInputStream(new FileInputStream(binaryfile));
		
		int len=(int) binaryfile.length();
		byte[] buffer=new byte[len];
        int totalBytesRead = 0;
        while(totalBytesRead < buffer.length){
            int bytesRemaining = buffer.length - totalBytesRead;
            int bytesRead = binaryis.read(buffer, totalBytesRead, bytesRemaining);
            if (bytesRead > 0){
                totalBytesRead = totalBytesRead + bytesRead;
            }
        }
        
        
        return  buffer;
	}
   	  
	 public String decodeMessageUsingTree(Node root, String message,  BufferedWriter bw) throws IOException{
		   Node utree = root;
	        Node n = null;
	        String residual = "";
	        while(message.length()>0){
	            for(int i=0; i<message.length();i++){
	                residual = residual + message.charAt(i);
	                if(message.charAt(i)=='0'){
	                	 n=root.left;
	                	 root=n;
						if(n.left==null && n.right==null ){
							 bw.write(n.value + "\n");
		                     bw.flush();
		                     message = message.substring(i+1);
							 root=utree;
							 residual = "";
		                     break;
						    }
						        
	                }else  if(message.charAt(i)=='1'){
	                	 n = root.right;
	                     root = n;
						if(n.left==null && n.right==null ){
							 bw.write(n.value + "\n");
		                     bw.flush();
		                     message = message.substring(i+1);
		                     root=utree;
							 residual = "";
		                     break;
						    }
	                }
	            }
	            if(residual.trim().length()>0){
	                //System.out.println(residual);
	                break;
	            }
	        }
	        return residual;  
		  
		 
		 
		 
		}
	 
	 public HashMap<Integer, String> buildMapFromTable(String code) throws NumberFormatException, IOException{
	 HashMap<Integer, String> map = new HashMap<Integer, String>();
	   BufferedReader code_file = new BufferedReader(new FileReader(code));
	   String line = "";
	   while ((line = code_file.readLine()) != null) {
         String parts[] = line.split(" ");
         map.put(Integer.parseInt(parts[0]), parts[1]);
     }
	   code_file.close();
	   return map;
	 }
	 
	 }
	
  
	



