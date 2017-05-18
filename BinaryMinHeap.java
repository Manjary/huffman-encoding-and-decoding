

public class BinaryMinHeap {
	private BinaryNode[] binaryHeapArray= new BinaryNode[1000001];
	private int BinaryHeapSize = 0;

	public int size(){
	   return BinaryHeapSize;
	}
    
	public BinaryMinHeap(int i){
		 binaryHeapArray = new BinaryNode[i];
	}
	
	public void insert(BinaryNode k){
		BinaryHeapSize++;
		int i = BinaryHeapSize;
		while(i>1 && binaryHeapArray[parent(i)].getFreq()> k.getFreq()){
			binaryHeapArray[i]=binaryHeapArray[parent(i)];
			i=parent(i);
		}
		binaryHeapArray[i]=k;
	}
	
	public int parent(int i) {
        return i/2;
    }
	
	public BinaryNode getMin(){
		if(BinaryHeapSize!=0)
			return binaryHeapArray[1];
		return null;
	}
	
/*	public BinaryNode delete_Min(){
		 if(BinaryHeapSize!=0){
			 BinaryNode min=binaryHeapArray[1];
			 binaryHeapArray[1]=binaryHeapArray[BinaryHeapSize];
			 BinaryHeapSize--;
			 heapify(1);
			 return min;
		 }
		 return null;
	}*/

	public void heapify(int i) {
	     int lc=left(i);
	     int rc=right(i);
	     int smallest;
	     if(rc<=BinaryHeapSize){
	    	 if(binaryHeapArray[lc].getFreq()<binaryHeapArray[rc].getFreq()){
	    		 smallest=lc;
	    	 }
	    	 else
	    		 smallest=rc;
	    	 
	    	 if(binaryHeapArray[i].getFreq()>binaryHeapArray[smallest].getFreq()){
	    		 swap(i,smallest);
	    		 heapify(smallest);
	    	 }
	    	}
	     else if(lc == BinaryHeapSize && binaryHeapArray[i].getFreq() > binaryHeapArray[lc].getFreq()) {
             swap(i, lc);
     }   
	}     
    private void swap(int i,int l){
	    	 BinaryNode tmp=binaryHeapArray[i];
	    	 binaryHeapArray[i]=binaryHeapArray[l];
	    	 binaryHeapArray[l]=tmp;
	     }
    public BinaryNode delMin() {
        if(BinaryHeapSize != 0) {
                BinaryNode min = binaryHeapArray[1];
                binaryHeapArray[1] = binaryHeapArray[BinaryHeapSize];
                BinaryHeapSize--;
                heapify(1);
                return min;
        }
        return null;
}
    
	public int left(int i){
		
    	return 2*i;
    }
    
	public int right(int i){
		
		return 2*i+1;
	}
	
    public BinaryNode getnode(int i){
    	return binaryHeapArray[i];
    }
    
    public BinaryNode[] getHeap(){
		return binaryHeapArray;
    	
    }
		
	
}
