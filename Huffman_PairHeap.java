

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Huffman_PairHeap {

	HashMap<Integer,Integer> hmap=new HashMap<Integer, Integer>();
	PairHeap pairHeap;
	 public HashMap<Integer,Integer> getFrequencies(String PATH) throws IOException, FileNotFoundException {
			Frequency f =new Frequency();
			hmap= f.read_file(PATH);
			return hmap;
		 }
	 
	 public PairHeap createHeap_Tree(HashMap<Integer,Integer> hmap) {
		 pairHeap = new PairHeap();
		 ArrayList<PairHeapNode> arr = new ArrayList<PairHeapNode>();
         for (Map.Entry<Integer, Integer> entry : hmap.entrySet()) {
                 if(entry.getValue() != 0) {
                	     int k = entry.getKey();
                         int v = entry.getValue();
                         PairHeapNode newNode = new PairHeapNode(v,k);
                         pairHeap.insertNewNode(newNode);
                         arr.add(newNode);       }
         }
       
         PairHeapNode h = pairHeap.getRootNode();

         

         int n = pairHeap.getSize() - 1;

         for(int i = 1; i<=n; i++){
             PairHeapNode newNode = new PairHeapNode();
             PairHeapNode a1 = pairHeap.deleteMin();
             PairHeapNode b1 = pairHeap.deleteMin();
             newNode.sethLeftChild(a1);
             newNode.sethRightChild(b1);
             newNode.setValue(newNode.hLeftChild.getValue() + newNode.hRightChild.getValue());
             newNode.setKey(0);

             pairHeap.insertNewNode(newNode);

         }
         PairHeapNode h1 = pairHeap.getRootNode();
         //System.out.println(h1.getElement());
                 return pairHeap;
   }
}	 
