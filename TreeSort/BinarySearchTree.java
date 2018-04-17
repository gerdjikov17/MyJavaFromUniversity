

public class BinarySearchTree {
	Node root;
	
	public class Node{
		Node left,right;
		int value;
		
		public Node(int value) {this.value=value;}
	}
	
	public void insert(int value) {
		Node insert = new Node(value);
		putInOrder(root,insert);
	}
	
	public void insertCollection(int[] arr) {
		for(int i = 0 ; i < arr.length ; i++) {
			insert(arr[i]);
		}
	}
	
	private boolean putInOrder(Node current, Node insert) {
		if(this.root==null) {root=insert; return true;}
		if(insert.value<current.value) {
			if(current.left != null) {
				return putInOrder(current.left,insert);
			}
			else {
				current.left=insert;
				return true;
			}
		}
		else{
			if(current.right != null ) {
				return putInOrder(current.right,insert);
			}
			else {
				current.right=insert;
				return true;
			}
		}
		
	}
	
	public void printInOrder() {
		Node current = root;
		printInOrder(current);
	}
	
	private void printInOrder(Node current) {
		if(current.left!= null) printInOrder(current.left);
		System.out.println(current.value);
		if(current.right!=null) printInOrder(current.right);
		return;
	}
}
