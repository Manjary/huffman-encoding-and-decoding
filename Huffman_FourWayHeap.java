

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Huffman_FourWayHeap {
	HashMap<Integer,Integer> hmap=new HashMap<Integer, Integer>();
	FourWayHeap minHeap;
	 public HashMap<Integer,Integer> getFrequencies(String PATH) throws IOException, FileNotFoundException {
			Frequency f =new Frequency();
			hmap= f.read_file(PATH);
			return hmap;
		 }

	 
	 
	 public FourWayHeap createHeap(HashMap<Integer,Integer> hmap) {
         minHeap = new FourWayHeap(1000001);
         for (Map.Entry<Integer, Integer> entry : hmap.entrySet()) {
                 if(entry.getValue() != 0) {
                         FourWayHeapNode node = new FourWayHeapNode(entry.getValue(),entry.getKey());
                         node.setLeaf();
                         minHeap.insertNode(node);
                 }
         }
        return minHeap;
	  }
	 
	 public void printHeap(FourWayHeap dHeap){
		FourWayHeapNode[] dHeapArray= dHeap.getHeap();
		for(int i=1 ; i<=dHeap.FourWayHeapSize() ;i++){
		//System.out.println(dHeapArray[i].getFreq());	
		}
	 }
	
	 
	 public FourWayHeap createTree(FourWayHeap dHeap) {
         int n = dHeap.FourWayHeapSize();
         for(int i = 0; i < (n-1); ++i) {
                 FourWayHeapNode z = new FourWayHeapNode();
                 z.setLeft_child(dHeap.delete_MinNode());
                 z.setRight_child(dHeap.delete_MinNode());
                 z.setFreq(z.getLeft_child().getFreq() + z.getRight_child().getFreq());
                 dHeap.insertNode(z);
         }
         return dHeap;
}
}

