package HashTables;

public class Executer {
	public static void main(String[] args) {
		CustomHashMap theHash = new CustomHashMap(31);
		String[] input = { "100", "510", "170", "214", "268", "398",
				"235", "802", "900", "723", "699", "1", "16", "999", "890",
				"725", "998", "978", "988", "990", "989", "984", "320", "321"};

		theHash.DoubleHash(input);
		theHash.displayCustomHashMap();
		theHash.findKeyDH("510");
		System.out.println("-----------------------------------");
/*		theHash.HashFunction2(input);
		theHash.displayHashTable();
		theHash.findKeyF2("510");*/
		System.out.println("Collisions "+theHash.getCollisions());
		
	}
}
