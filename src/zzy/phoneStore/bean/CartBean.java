package zzy.phoneStore.bean;

public class CartBean {

	private String username;
	private String phonename;
	private double price;
	private int num;
	private String address;

	public CartBean() {
		super();
	}

	public CartBean(String username, String phonename, double price, int num,
			String address) {
		super();
		this.username = username;
		this.phonename = phonename;
		this.price = price;
		this.num = num;
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhonename() {
		return phonename;
	}

	public void setPhonename(String phonename) {
		this.phonename = phonename;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		String str = username+" "+phonename + " " + price + " " + num + " " + address;
		return str;
	}

}
