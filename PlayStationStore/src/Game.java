import java.io.Serializable;

public class Game implements Serializable {

	private static final long serialVersionUID = 1L;
	private String title;
	private String description;
	private double price;
	private int quantity;
	private String genre;
	private String platform;
	private int discount;
	private double priceAfterDiscount;
	private int id;
	
	public void setId(int id) {
		this.id=id;
	}
	public double getPriceAfterDiscount() {
		return priceAfterDiscount;
	}
	public void setPriceAfterDiscount(double priceAfterDiscount) {
		this.priceAfterDiscount = priceAfterDiscount;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
		if(this.discount!=0) {
			this.priceAfterDiscount=price-(price*this.discount);
		}
	}
	public Game(String title, String description, double price, int quantity, String genre, String platform,
			int discount) {
		super();
		this.title = title;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.genre = genre;
		this.platform = platform;
		this.discount = discount;
		this.priceAfterDiscount=price-(price*this.discount/100);
	}
	@Override
	public String toString() {
		return "Game [ID="+this.id+", Title=" + title + ", Description=" + description + ", Price=" + price + ", Quantity=" + quantity
				+ ", Genre=" + genre + ", Platform=" + platform + ", Discount=" + discount + ", PriceAfterDiscount="
				+ priceAfterDiscount + "]";
	}
	
}
