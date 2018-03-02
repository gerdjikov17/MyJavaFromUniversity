import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class PlayStationStore {
	private ArrayList<Game> games = new ArrayList<>();
	private ArrayList<PlayStation> playStations = new ArrayList<>();
	private double income=0;
	
	
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income += income;
	}
	
	
	public void addGame(Game game) {
		games.add(game);
	}
	public void addPS(PlayStation ps) {
		playStations.add(ps);
	}
	
	public void addGame() throws InputMismatchException{
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Title:");
		String title = sc.nextLine();
		
		System.out.println("Description:");
		String description = sc.nextLine();
		
		System.out.println("Price:");
		double price = sc.nextDouble();
		
		System.out.println("Quantity:");
		int quantity = sc.nextInt();
		sc.nextLine();
		System.out.println("Genre:");
		String genre = sc.nextLine();
		
		System.out.println("Platform:");
		String platform = sc.nextLine();
		
		System.out.println("Discount:");
		int discount = sc.nextInt();

		Game game = new Game(title, description, price, quantity, genre, platform, discount);
		game.setId(games.size()+1);
		addGame(game);
		//sc.close();
	}
	
	public void LoadFromFile() {
		
			Game temp = null;
			boolean cont = true;
			File gamesFile = new File("games.bin");
			ObjectInputStream ois = null;
			try {
				ois = new ObjectInputStream (new FileInputStream(gamesFile));
				while(cont) {
					temp=(Game)ois.readObject();
					if(temp!=null) {
						this.games.add(temp);
					}
				}
			}
			catch(EOFException e) {
				
			}
			catch(IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				if(ois!=null)
					try {
						ois.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			PlayStation temp2 = null;
			boolean cont2 = true;
			File playStationFile = new File("playStation.bin");
			ObjectInputStream ois2 = null;
			try {
				
				ois2 = new ObjectInputStream (new FileInputStream(playStationFile));
				while(cont2) {
					
					temp2=(PlayStation)ois2.readObject();
					if(temp2!=null) {
						this.playStations.add(temp2);
					}
					else cont2=false;
				}
			}
			catch(EOFException e) {
				
			}
			catch(IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				if(ois2!=null)
					try {
						ois2.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
	}
	public void addPS() throws InputMismatchException{
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Model:");
		String model = sc.nextLine();
		
		System.out.println("Space:");
		String space = sc.nextLine();
		
		System.out.println("Color:");
		String color = sc.nextLine();
		
		System.out.println("Quantity:");
		int quantity = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Dualshocks:");
		int dualshocks = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Price:");
		double price = sc.nextDouble();
		
		System.out.println("Discount:");
		int discount = sc.nextInt();
		
		PlayStation ps = new PlayStation(model, space, color, quantity, dualshocks, price, discount);
		ps.setID(games.size()+1);
		addPS(ps);
	}
	
	public void LoadFromFile(String product) throws IOException {
		if(product.equalsIgnoreCase("game"))
		{
			Game temp = null;
			boolean cont = true;
			File gamesFile = new File("games.bin");
			ObjectInputStream ois = null;
			try {
				ois = new ObjectInputStream (new FileInputStream(gamesFile));
				while(cont) {
					temp=(Game)ois.readObject();
					if(temp!=null) {
						games.add(temp);
						System.out.println(games.size());
						games.get(games.size()).setId(games.size());		
						}
					else cont=false;
				}
			}
			catch(IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				if(ois!=null)ois.close();
			}
		}
		else if (product.equalsIgnoreCase("play station")) {
			PlayStation temp = null;

			boolean cont = true;
			File playStationFile = new File("playStation.bin");
			ObjectInputStream ois = null;
			try {
				ois = new ObjectInputStream (new FileInputStream(playStationFile));
				while(cont) {
					temp=(PlayStation)ois.readObject();
					if(temp!=null) {
						playStations.add(temp);
					}
					else cont=false;
				}
			}
			catch(IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				if(ois!=null)ois.close();
			}
		}
	}
	
	public void WriteInFile() {
		File gamesFile = new File("games.bin");
		File psFile = new File("playStation.bin");
		ObjectOutputStream oos = null;
		if(!games.isEmpty()) {
			try {
				oos = new ObjectOutputStream(new FileOutputStream(gamesFile));
				for(int i = 0; i<games.size();i++) {
					oos.writeObject(games.get(i));
				}
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			finally {
				if(oos!=null)
					try {
						oos.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
		if(!playStations.isEmpty()) {
			try {
			oos = new ObjectOutputStream(new FileOutputStream(psFile));
			for(int i = 0 ; i < playStations.size() ; i++) {
				oos.writeObject(playStations.get(i));
			}
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			finally {
				if(oos!=null)
					try {
						oos.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
	}
	
	public void printAll() {

		if(!games.isEmpty()) {
			for(int i = 0 ; i < games.size() ; i++) {
				System.out.println(games.get(i).toString());
			}
		}
		if(!playStations.isEmpty()) {
			for(int i = 0 ; i < playStations.size() ; i++) {
				System.out.println(playStations.get(i).toString());
			}
		}
	}
	public void printGames() {
		if(!games.isEmpty()) {
			for(int i = 0 ; i < games.size() ; i++) {
				System.out.println(games.get(i).toString());
			}
		}
	}
	public void printConsoles() {
		if(!playStations.isEmpty()) {
			for(int i = 0 ; i < playStations.size() ; i++) {
				System.out.println(playStations.get(i).toString());
			}
		}
	}
	public void sellGame(String gameName,int quantity) {
		boolean gameFound=false;
		int quantitySold=0;
		if(!games.isEmpty()) {
			for(int i = 0 ; i < games.size() ; i++) {
				if(games.get(i).getTitle().equalsIgnoreCase(gameName)) {
					gameFound=true;
					if(games.get(i).getQuantity()>quantity) {
						setIncome(quantity*games.get(i).getPriceAfterDiscount());
						games.get(i).setQuantity(games.get(i).getQuantity()-quantity);
						quantitySold=quantity;
					}
					else {
						quantitySold=games.get(i).getQuantity();
						setIncome(games.get(i).getPriceAfterDiscount()*quantitySold);
						games.remove(i);
					}
				}
			}
			System.out.println("Game found ["+gameFound+"] Quantity sold ["+quantitySold+"]");
		}
	}
	public void sellConsole(int id,int quantity) {
		boolean psFound=false;
		int quantitySold=0;
		if(!playStations.isEmpty()) {
			for(int i = 0 ; i < games.size() ; i++) {
				if(playStations.get(i).getID()==id) {
					psFound=true;
					if(playStations.get(i).getQuantity()>quantity) {
						setIncome(quantity*playStations.get(i).getPriceAfterDiscount());
						playStations.get(i).setQuantity(playStations.get(i).getQuantity()-quantity);
						quantitySold=quantity;
					}
					else {
						quantitySold=playStations.get(i).getQuantity();
						setIncome(playStations.get(i).getPriceAfterDiscount()*quantitySold);
						playStations.remove(i);
					}
				}
			}
			System.out.println("Game found ["+psFound+"] Quantity sold ["+quantitySold+"]");
		}
	}


}
