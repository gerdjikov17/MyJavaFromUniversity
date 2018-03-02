import java.io.Serializable;

public class PlayStation implements Serializable {

	private static final long serialVersionUID = 1L;
	private int ID;
	private String model;
	private String space;
	private String color;
	private int dualshocks;
	private double price;
	private int discount;
	private int quantity;
	private double priceAfterDiscount;
	
	
	public PlayStation(String model, String space, String color,int quantity, int dualshocks, double price, int discount) {
		super();
		this.model = model;
		this.space = space;
		this.color = color;
		this.dualshocks = dualshocks;
		this.price = price;
		this.discount = discount;
		this.quantity=quantity;
		this.priceAfterDiscount=price-(price*discount/100);
	}
	public double getPriceAfterDiscount() {
		return priceAfterDiscount;
	}
	public void setPriceAfterDiscount(double priceAfterDiscount) {
		this.priceAfterDiscount = priceAfterDiscount;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getSpace() {
		return space;
	}
	
	public void setSpace(String space) {
		this.space = space;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getDualshocks() {
		return dualshocks;
	}
	public void setDualshocks(int dualshocks) {
		this.dualshocks = dualshocks;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	@Override
	public String toString() {
		return "PlayStation [ID="+ID+", Model=" + model + ", Space=" + space + ", Color=" + color + ", Quantity="+quantity+", Dualshocks=" + dualshocks
				+ ", Price=" + price + ", Discount=" + discount + ", PriceAfterDiscount="+priceAfterDiscount+"]";
	}
	
}
