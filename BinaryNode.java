

/**
 * @desc this class define the struture of Binary Heap Node
 * @author Manjary Modi
 *
 */

public class BinaryNode {
	
        private BinaryNode parent;
        private BinaryNode lefthild;
        private BinaryNode rightChild;
        private int key = -1;
        private int freq = -1;
        private boolean isLeaf = false;
        
        public BinaryNode() { 
        }
        public BinaryNode(int freq, int i) {  
            this.key = i;
            this.freq = freq;
        }
	
        public BinaryNode getParent() {
			return parent;
		}

        
		public void setParent(BinaryNode parent) {
			this.parent = parent;
		}

		public BinaryNode getLeft() {
			return lefthild;
		}

		public void setLeft(BinaryNode left) {
			this.lefthild = left;
		}

		public BinaryNode getRight() {
			return rightChild;
		}

		public void setRight(BinaryNode right) {
			this.rightChild = right;
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

		public void setToLeaf() {
            isLeaf = true;
        }
        
}