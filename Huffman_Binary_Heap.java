
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public class Huffman_Binary_Heap {
	 HashMap<Integer,Integer> hmap=new HashMap<Integer, Integer>();
	 BinaryMinHeap minHeap;
	 int numberOfInput;
	 
	 public void code(String PATH) throws FileNotFoundException, IOException {
         getFrequencies(PATH);
         long startTime = System.currentTimeMillis();
         generateTree(hmap); 
         long endTime = System.currentTimeMillis();
         System.out.println("Time to generate tree --"+(endTime - startTime)*1000);
         /*//generateCode(minHeap.getMin(), "");        
         System.out.println("Writing file");
         writeFile(PATH, symbolTable);
         System.out.println("done");
*/       }
	 public HashMap<Integer,Integer> getFrequencies(String PATH) throws IOException, FileNotFoundException {
		Frequency f =new Frequency();
		hmap= f.read_file(PATH);
		return hmap;
	 }
	 
	 public BinaryMinHeap generateTree(HashMap<Integer,Integer> hmap) {
		/* System.out.println("Creating heap");*/
		 createHeap(hmap);
		 minHeap = createTree(minHeap);
		 return minHeap;
	 }
	 
     private void createHeap(HashMap<Integer,Integer> hmap) {
         minHeap = new BinaryMinHeap(1000001);
         for (Map.Entry<Integer, Integer> entry : hmap.entrySet()) {
                 if(entry.getValue() != 0) {
                         BinaryNode node = new BinaryNode(entry.getValue(),entry.getKey());
                         node.setToLeaf();
                         minHeap.insert(node);
                 }
         }
 
	 
	 
     }
     
     private BinaryMinHeap createTree(BinaryMinHeap minHeap) {
         int n = minHeap.size();
         for(int i = 0; i < (n-1); ++i) {
                 BinaryNode z = new BinaryNode();
                 z.setLeft(minHeap.delMin());
                 z.setRight(minHeap.delMin());
                 z.setFreq(z.getLeft().getFreq() + z.getRight().getFreq());
                 minHeap.insert(z);
         }
         return minHeap;
 }

    /* public void printHeap(){
    	 int i=1;
    	 for(i=1; i<=minHeap.size(); i++){
    		 System.out.println(minHeap.getnode(i).getKey()+"-----"+minHeap.getnode(i).getFreq());
    	 }
    	
     }
     */
     
     
}

