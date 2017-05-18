

public class FourWayHeap {
	private FourWayHeapNode[] dHeapArray;
   //initializing the size of array with 0
	private int FourwayHeapSize = 0;
    
	public int FourWayHeapSize(){
	   return FourwayHeapSize;
	}
    
	public FourWayHeap(int i){
		dHeapArray = new FourWayHeapNode[i];
	}
	
	public void insertNode(FourWayHeapNode node){
		
		int i = FourwayHeapSize;
		while(i>0 && dHeapArray[parent(i)].getFreq()> node.getFreq()){
			dHeapArray[i]=dHeapArray[parent(i)];
			i=parent(i);
		}
		dHeapArray[i]=node;
		FourwayHeapSize++;
	}
	public int parent(int i) {
        return (i-1)/4;
    }
	
	
	public FourWayHeapNode getMinNode(){
		if(FourwayHeapSize!=0)
			return dHeapArray[0];
		return null;
	}
	public FourWayHeapNode delete_MinNode(){
		 if(FourwayHeapSize!=0){
			 FourWayHeapNode min=dHeapArray[0];
			 FourwayHeapSize--;
			 dHeapArray[0]=dHeapArray[FourwayHeapSize];
			 
			 heapify(0);
			 return min;
		 }
		 return null;
	}
	  public int findMinChild(int start, int end){
	        int minChild = start;
	        for(int i = start+1; (i<=end && i<FourwayHeapSize); i++){
	            if(dHeapArray[minChild].getFreq() > dHeapArray[i].getFreq()){
	                minChild = i;
	            }
	        }
	        return minChild;
	    }

	
	public void heapify(int i){
		int child_one=4*i+1;
		int child_two=4*i+2;
		int child_three=4*i+3;
		int child_four=4*i+4;
		int minchild = findMinChild(child_one,child_four);
		
	        FourWayHeapNode cr = dHeapArray[i];
	        while ((minchild <FourwayHeapSize) && (dHeapArray[minchild].getFreq() < cr.getFreq())){
	        	dHeapArray[i] = dHeapArray[minchild];
	            i = minchild;
	            minchild = findMinChild(minchild*4+1, minchild*4+4);
	        }
	        dHeapArray[i] = cr;
		}

	
	private void swapTwoNode(int i,int l){
		FourWayHeapNode tmp=dHeapArray[i];
		dHeapArray[i]=dHeapArray[l];
		dHeapArray[l]=tmp;
    }
	
	public FourWayHeapNode[] getHeap(){
		return dHeapArray;
    	
    }
	
	
 }
	

