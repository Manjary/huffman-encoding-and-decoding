

public class PairHeap {

	    private PairHeapNode rootNode;
	    private PairHeapNode [ ] treeArrayPairHeap = new PairHeapNode[5];
	    private int currentHeapSize = 0;
	   
	    
	    public PairHeap( )
	    {
	        rootNode = null;
	      }
	    
	    public int getSize(){
	        return currentHeapSize;
	    }
	    
	    public boolean isEmpty() 
	    {
	        return rootNode == null;
	    }
	     
	    public void makeEmpty( )
	    {
	        rootNode = null;
	    }
	    
	    public PairHeapNode insertNewNode(PairHeapNode newNode)
	    {   currentHeapSize = currentHeapSize + 1;
	        if (rootNode == null)
	            rootNode = newNode;
	        else
	            rootNode = compareAndConnect(rootNode, newNode);
	        return newNode;
	    }
	    
	    private PairHeapNode compareAndConnect(PairHeapNode node_one, PairHeapNode node_two)
	    {
	        if (node_two == null)
	            return node_one;
	 
	        if (node_two.value < node_one.value)
	        {
	            /* Attach first as leftmost child of second */
	            node_two.prevSibling = node_one.prevSibling;
	            node_one.prevSibling = node_two;
	            node_one.nextSibling = node_two.child;
	            if (node_one.nextSibling != null)
	                node_one.nextSibling.prevSibling = node_one;
	            node_two.child = node_one;
	            return node_two;
	        }
	        else
	        {
	    
	            node_two.prevSibling = node_one;
	            node_one.nextSibling = node_two.nextSibling;
	            if (node_one.nextSibling != null)
	                node_one.nextSibling.prevSibling = node_one;
	            node_two.nextSibling = node_one.child;
	            if (node_two.nextSibling != null)
	                node_two.nextSibling.prevSibling = node_two;
	            node_one.child = node_two;
	            return node_one;
	        }
	    }
	    private PairHeapNode combineSiblings(PairHeapNode firstSibling)
	    {
	        if( firstSibling.nextSibling == null )
	            return firstSibling;
	    
	        int numSiblings = 0;
	        for ( ; firstSibling != null; numSiblings++)
	        {
	            treeArrayPairHeap = doubleIfFull( treeArrayPairHeap, numSiblings );
	            treeArrayPairHeap[ numSiblings ] = firstSibling;
	            /* break links */
	            firstSibling.prevSibling.nextSibling = null;  
	            firstSibling = firstSibling.nextSibling;
	        }
	        treeArrayPairHeap = doubleIfFull( treeArrayPairHeap, numSiblings );
	        treeArrayPairHeap[ numSiblings ] = null;
	    
	        int i = 0;
	        for ( ; i + 1 < numSiblings; i += 2)
	            treeArrayPairHeap[ i ] = compareAndConnect(treeArrayPairHeap[i], treeArrayPairHeap[i + 1]);
	        int j = i - 2;
	        if (j == numSiblings - 3)
	            treeArrayPairHeap[ j ] = compareAndConnect( treeArrayPairHeap[ j ], treeArrayPairHeap[ j + 2 ] );
	        for ( ; j >= 2; j -= 2)
	            treeArrayPairHeap[j - 2] = compareAndConnect(treeArrayPairHeap[j-2], treeArrayPairHeap[j]);
	        return treeArrayPairHeap[0];
	    }
	    private PairHeapNode[] doubleIfFull(PairHeapNode [ ] array, int index)
	    {
	        if (index == array.length)
	        {
	            PairHeapNode [ ] oldArray = array;
	            array = new PairHeapNode[index * 2];
	            for( int i = 0; i < index; i++ )
	                array[i] = oldArray[i];
	        }
	        return array;
	    }
	    
	    public PairHeapNode  deleteMin( )
	    {
	        if (isEmpty( ) )
	            return null;
	        PairHeapNode x = rootNode;
	        currentHeapSize = currentHeapSize - 1;
	        if (rootNode.child == null)
	            rootNode = null;
	        else
	            rootNode = combineSiblings( rootNode.child );
	        return x;
	    }
	    
	    public void inorder()
	    {
	        inorder(rootNode);
	    }
	    private void inorder(PairHeapNode r)
	    {
	        if (r != null)
	        {
	            inorder(r.child);
	            System.out.print(r.value +" = "+r.getKey() +" ->");
	            inorder(r.nextSibling);
	        }
	    }
	    
	    
	    public PairHeapNode getRootNode(){
	        return rootNode;
	    }
	}

