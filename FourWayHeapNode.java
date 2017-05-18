
/**
 * @desc this class define the struture of 4way Heap Node
 * @author Manjary Modi
 *
 */

public class FourWayHeapNode {
	
	        private FourWayHeapNode parent;
	        private FourWayHeapNode child_one;
	        private FourWayHeapNode child_two;
	        private FourWayHeapNode child_three;
	        private FourWayHeapNode child_four;
	        private FourWayHeapNode left_child;
	        private FourWayHeapNode right_child;
	        private int key = -1;
	        private int freq = -1;
	        private boolean isLeaf = false;
	        
	        public FourWayHeapNode() { 
	        }
	        public FourWayHeapNode(int freq, int i) {  
	            this.key = i;
	            this.freq = freq;
	        }
			public FourWayHeapNode getParent() {
				return parent;
			}
			public void setParent(FourWayHeapNode parent) {
				this.parent = parent;
			}
			public FourWayHeapNode getChild_one() {
				return child_one;
			}
			public void setChild_one(FourWayHeapNode child_one) {
				this.child_one = child_one;
			}
			public FourWayHeapNode getChild_two() {
				return child_two;
			}
			public void setChild_two(FourWayHeapNode child_two) {
				this.child_two = child_two;
			}
			public FourWayHeapNode getChild_three() {
				return child_three;
			}
			public void setChild_three(FourWayHeapNode child_three) {
				this.child_three = child_three;
			}
			public FourWayHeapNode getChild_four() {
				return child_four;
			}
			public void setChild_four(FourWayHeapNode child_four) {
				this.child_four = child_four;
			}
			public int getKey() {
				return key;
			}
			public void setKey(int key) {
				this.key = key;
			}
			public int getFreq() {
				return freq;
			}
			public void setFreq(int freq) {
				this.freq = freq;
			}
			public boolean isLeaf() {
				return isLeaf;
			}
			public void setLeaf() {
				this.isLeaf = true;
			}
			public FourWayHeapNode getLeft_child() {
				return left_child;
			}
			public void setLeft_child(FourWayHeapNode left_child) {
				this.left_child = left_child;
			}
			public FourWayHeapNode getRight_child() {
				return right_child;
			}
			public void setRight_child(FourWayHeapNode right_child) {
				this.right_child = right_child;
			}
		     
}
