
public class TestTree {

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		
		int[] collection = {5,4,6,7,4,12,22,43,8,1};
		
		printIntArray(collection);
		printRow();
		
		tree.insertCollection(collection);
		
		tree.printInOrder();
		
		tree.insert(15);
		
		printRow();
		tree.printInOrder();

	}
	
	public static void printIntArray(int[] arr) {
		for(int i = 0 ; i < arr.length ; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void printRow() {
		System.out.println("=======================================");
	}

}
