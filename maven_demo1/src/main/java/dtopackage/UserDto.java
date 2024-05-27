package dtopackage;

public class UserDto {
	private int id;
	private String name;
	private long phone;
	private String mailid;
	private String password;
	private int wallet;

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

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getMailid() {
		return mailid;
	}

	public void setMailid(String mailid) {
		this.mailid = mailid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getWallet() {
		return wallet;
	}

	public void setWallet(int wallet) {
		this.wallet = wallet;
	}

	public UserDto(int id, String name, long phone, String mailid, String password, int wallet) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.mailid = mailid;
		this.password = password;
		this.wallet = wallet;
	}

	public String toString() {
		return "UserDto [id=" + id + ", name=" + name + ", phone=" + phone + ", mailid=" + mailid + ", password="
				+ password + ", wallet=" + wallet + "]";
	}

}
