package ADS;

public class DHeap {
	private DHeapNode[] dHeapArray;
	private int size = 0;
    
	public int size(){
	   return size;
	}
    
	public DHeap(int i){
		dHeapArray = new DHeapNode[i];
	}
	
	public void insert(DHeapNode k){
		
		int i = size;
		while(i>0 && dHeapArray[parent(i)].getFreq()> k.getFreq()){
			dHeapArray[i]=dHeapArray[parent(i)];
			i=parent(i);
		}
		dHeapArray[i]=k;
		size++;
	}
	public int parent(int i) {
        return (i-1)/4;
    }
	
	
	public DHeapNode getMin(){
		if(size!=0)
			return dHeapArray[0];
		return null;
	}
	public DHeapNode delete_Min(){
		 if(size!=0){
			 DHeapNode min=dHeapArray[0];
			 size--;
			 dHeapArray[0]=dHeapArray[size];
			 
			 heapify(0);
			 return min;
		 }
		 return null;
	}
	  public int findMinChild(int s, int e){
	        int minChild = s;
	        for(int i = s+1; (i<=e && i<size); i++){
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
		
	        DHeapNode cr = dHeapArray[i];
	        while ((minchild <size) && (dHeapArray[minchild].getFreq() < cr.getFreq())){
	        	dHeapArray[i] = dHeapArray[minchild];
	            i = minchild;
	            minchild = findMinChild(minchild*4+1, minchild*4+4);
	            //System.out.println("hi2");
	        }
	        dHeapArray[i] = cr;

	        //System.out.println("hi");



	/*        if(four <= currentheapsize){

	            minchild = one;
	            for(int c = one+1; (c<=four && c<currentheapsize); c++){
	                if(dheap[minchild].getValue() > dheap[c].getValue()){
	                    minchild = c;
	                }
	            }

	            if(dheap[i].getValue() > dheap[minchild].getValue()){
	                swap( i, minchild );
	                heapify( minchild );
	            }

	        }else{
	            minchild = one;
	            int flag = 0;
	            if(one==currentheapsize)
	                flag =1;
	            if(two==currentheapsize)
	                flag =2;
	            if(three==currentheapsize)
	                flag =3;
	            if(flag!=0){
	                    for(int c = one + 1; c<= one + flag; c++){
	                    if(dheap[minchild].getValue() > dheap[c].getValue()){
	                        minchild = c;
	                    }
	                }
	                if(dheap[i].getValue() > dheap[minchild].getValue())
	                    swap(i,minchild);
	            }


	*//*            int numleafs = 4 - (four-currentheapsize);
	            if(numleafs!=0){
	                minchild = one;
	                for(int c = one+1; c<=numleafs+1; c++){
	                    if(dheap[minchild].getValue() > dheap[c].getValue()){
	                        minchild = c;
	                    }
	                }
	                if(dheap[i].getValue() > dheap[minchild].getValue()){
	                    swap(i,minchild);
	                }
	            }*//*
	        }*/

		}

	
	private void swap(int i,int l){
		DHeapNode tmp=dHeapArray[i];
		dHeapArray[i]=dHeapArray[l];
		dHeapArray[l]=tmp;
    }
	
	public DHeapNode[] getHeap(){
		return dHeapArray;
    	
    }
	
	
 }
	

