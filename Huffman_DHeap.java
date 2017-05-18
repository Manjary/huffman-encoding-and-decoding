package ADS;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Huffman_DHeap {
	HashMap<Integer,Integer> hmap=new HashMap<Integer, Integer>();
	DHeap minHeap;
	 public HashMap<Integer,Integer> getFrequencies(String PATH) throws IOException, FileNotFoundException {
			Frequency f =new Frequency();
			hmap= f.read_file(PATH);
			return hmap;
		 }

	 
	 
	 public DHeap createHeap(HashMap<Integer,Integer> hmap) {
         minHeap = new DHeap(1000001);
         for (Map.Entry<Integer, Integer> entry : hmap.entrySet()) {
                 if(entry.getValue() != 0) {
                         DHeapNode node = new DHeapNode(entry.getValue(),entry.getKey());
                         node.setLeaf();
                         minHeap.insert(node);
                 }
         }
        return minHeap;
	  }
	 
	 public void printHeap(DHeap dHeap){
		DHeapNode[] dHeapArray= dHeap.getHeap();
		for(int i=1 ; i<=dHeap.size() ;i++){
		//System.out.println(dHeapArray[i].getFreq());	
		}
	 }
	
	 
	 public DHeap createTree(DHeap dHeap) {
         int n = dHeap.size();
         for(int i = 0; i < (n-1); ++i) {
                 DHeapNode z = new DHeapNode();
                 z.setLeft_child(dHeap.delete_Min());
                 z.setRight_child(dHeap.delete_Min());
                 z.setFreq(z.getLeft_child().getFreq() + z.getRight_child().getFreq());
                 dHeap.insert(z);
         }
         return dHeap;
}
}

