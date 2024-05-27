package dtopackage;

public class ToyStoreDto {
	private int id;
	private String toyName;
	private long price;
	private long quantity;
	private String emailToy;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getToyName() {
		return toyName;
	}

	public void setToyName(String toyName) {
		this.toyName = toyName;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public String getEmailToy() {
		return emailToy;
	}

	public void setEmailToy(String emailToy) {
		this.emailToy = emailToy;
	}

	public ToyStoreDto(int id, String toyName, long price, long quantity, String emailToy) {
		this.id = id;
		this.toyName = toyName;
		this.price = price;
		this.quantity = quantity;
		this.emailToy = emailToy;
	}

	@Override
	public String toString() {
		return "ToyStoreDto [id=" + id + ", toyName=" + toyName + ", price=" + price + ", quantity=" + quantity
				+ ", emailToy=" + emailToy + "]";
	}

}
