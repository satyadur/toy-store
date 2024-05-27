package dtopackage;

public class AddToCartDto {
	private int id;
	private String name;
	private long quantity;
	private long price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public AddToCartDto(int id, String name, long quantity, long price) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	public String toString() {
		return "AddToCartDto [id=" + id + ", name=" + name + ", quantity=" + quantity + ", price=" + price + "]";
	}

}
