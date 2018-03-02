import java.util.Scanner;

public class Store {
	static PlayStationStore PSStore = new PlayStationStore();
	
	public void menu() {
        Scanner scanner = new Scanner(System.in);
		String choice = "something";
		int quantity;
		while(!"exit".equalsIgnoreCase(choice)) {
		System.out.println("================================================================");
		System.out.printf("Income = [%.2f]%n",PSStore.getIncome());
		System.out.println("================================================================");
        System.out.println("This is the menu:\n[1]Display all products in the store.\n[2]Display Games.\n[3]Display PlayStation Consoles."+
                "\n[4]Sell Game.\n[5]Sell Console.\n[6]Add Game.\n[7]Add Console.\n[8]Save data.\n[EXIT/exit]Exit.");
        choice =  scanner.nextLine();
        switch (choice) {
            case "1":
                PSStore.printAll();
                choice=null;
                break;
            case "2":
                PSStore.printGames();
                choice=null;
                break;
            case "3":
                PSStore.printConsoles();
                choice=null;
                break;
            case "4":
            	System.out.print("Write game name: ");
            	String gameName = scanner.nextLine();
            	System.out.print("Write quantity: ");
            	quantity = scanner.nextInt();
            	PSStore.sellGame(gameName, quantity);
            	choice=null;
            	break;
            case "5":
            	System.out.print("Write Console ID: ");
            	int id = scanner.nextInt();
            	System.out.print("Write quantity: ");
            	quantity = scanner.nextInt();
            	PSStore.sellConsole(id, quantity);
            	choice=null;
            	break;
            case "6":
            	PSStore.addGame();
            	choice=null;
            	break;
            case "7":
            	PSStore.addPS();
            	choice=null;
            	break;
            case "8":
            	PSStore.WriteInFile();
            	choice=null;
            	break;
        }
        }
        	scanner.close();

    }
	public static void main(String[] args) {
		
/*		Game game1 = new Game("Star Wars Battlefront II", "A Star Wars Game", 99.99, 3, "RPG", "PlayStation 4",0);
		PlayStation ps1 = new PlayStation("PlayStation 4 Pro", "1TB", "Gold", 2, 1000, 5,3);
		PSStore.addGame(game1);
		PSStore.addPS(ps1);
		PSStore.WriteInFile();*/
		
		Store store = new Store();

		PSStore.LoadFromFile();
		store.menu();
	}
}
