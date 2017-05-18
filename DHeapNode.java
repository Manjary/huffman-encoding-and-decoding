package ADS;

public class DHeapNode {
	
	        private DHeapNode parent;
	        private DHeapNode child_one;
	        private DHeapNode child_two;
	        private DHeapNode child_three;
	        private DHeapNode child_four;
	        private DHeapNode left_child;
	        private DHeapNode right_child;
	        private int key = -1;
	        private int freq = -1;
	        private boolean isLeaf = false;
	        
	        public DHeapNode() { 
	        }
	        public DHeapNode(int freq, int i) {  
	            this.key = i;
	            this.freq = freq;
	        }
			public DHeapNode getParent() {
				return parent;
			}
			public void setParent(DHeapNode parent) {
				this.parent = parent;
			}
			public DHeapNode getChild_one() {
				return child_one;
			}
			public void setChild_one(DHeapNode child_one) {
				this.child_one = child_one;
			}
			public DHeapNode getChild_two() {
				return child_two;
			}
			public void setChild_two(DHeapNode child_two) {
				this.child_two = child_two;
			}
			public DHeapNode getChild_three() {
				return child_three;
			}
			public void setChild_three(DHeapNode child_three) {
				this.child_three = child_three;
			}
			public DHeapNode getChild_four() {
				return child_four;
			}
			public void setChild_four(DHeapNode child_four) {
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
			public DHeapNode getLeft_child() {
				return left_child;
			}
			public void setLeft_child(DHeapNode left_child) {
				this.left_child = left_child;
			}
			public DHeapNode getRight_child() {
				return right_child;
			}
			public void setRight_child(DHeapNode right_child) {
				this.right_child = right_child;
			}
		     
}
