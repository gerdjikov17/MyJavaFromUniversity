
public class TheAnimalFactory {
	public Animal createAnimal(String obj) {
		if(obj.equalsIgnoreCase("bear")) 
			return new Bear();
		else if(obj.equalsIgnoreCase("crocodile"))
			return new Crocodile();
		else if(obj.equalsIgnoreCase("elephant"))
			return new Elephant();
		else return null;
	}
}
