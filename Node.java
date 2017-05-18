
public class Node {
       Node left=null;
       Node right=null;
       String code=null;
       int value= -1;
	public Node getLeft() {
		return left;
	}
	public Node(String code, int value){
		this.setCode(code);
		this.setValue(value);
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
       
}