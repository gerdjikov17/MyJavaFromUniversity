
public class TheFactoryTest {

	public static void main(String[] args) {
		TheAnimalFactory god = new TheAnimalFactory();
		Bear mechok = (Bear)god.createAnimal("bear");
		mechok.explain();
		mechok.saySomething();
		Elephant slon = (Elephant)god.createAnimal("elephant");
		slon.explain();
	}

}
