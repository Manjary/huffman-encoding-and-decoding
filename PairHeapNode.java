
/**
 * @desc this class define the struture of pairing Heap Node
 * @author Manjary Modi
 *
 */

public class PairHeapNode {
	
	    int value;
	    private int key;
	    private boolean isLeaf = false;
	    PairHeapNode child;
	    PairHeapNode nextSibling;
	    PairHeapNode prevSibling;
	    PairHeapNode hLeftChild;
	    PairHeapNode hRightChild;

	    public PairHeapNode gethLeftChild() {
	        return hLeftChild;
	    }

	    public void sethLeftChild(PairHeapNode hLeftChild) {
	        this.hLeftChild = hLeftChild;
	    }

	    public PairHeapNode gethRightChild() {
	        return hRightChild;
	    }

	    public void sethRightChild(PairHeapNode hRightChild) {
	        this.hRightChild = hRightChild;
	    }

	    
	    public PairHeapNode(){

	    }

	    public PairHeapNode(int x, int k)
	    {
	        value = x;
	        key = k;
	        child = null;
	        nextSibling = null;
	        prevSibling = null;
	    }

	    public int getValue() {
	        return value;
	    }

	    public void setValue(int value) {
	        this.value = value;
	    }

	    public int getKey() {
	        return key;
	    }

	    public void setKey(int key) {
	        this.key = key;
	    }

	    public boolean isLeaf() {
	        return isLeaf;
	    }

	    public void setToLeaf() {
	        isLeaf = true;
	    }

	    public PairHeapNode getChild() {
	        return child;
	    }

	    public void setChild(PairHeapNode child) {
	        this.child = child;
	    }

	    public PairHeapNode getNextSibling() {
	        return nextSibling;
	    }

	    public void setNextSibling(PairHeapNode nextSibling) {
	        this.nextSibling = nextSibling;
	    }

	    public PairHeapNode getPrevSibling() {
	        return prevSibling;
	    }

	    public void setPrevSibling(PairHeapNode prevSibling) {
	        this.prevSibling = prevSibling;
	    }
}
