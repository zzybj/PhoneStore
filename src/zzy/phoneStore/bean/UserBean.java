package zzy.phoneStore.bean;

public class UserBean {

	private String username;
	private String password;
	private String password2;
	private String email;
	private String phone;
	private String address;
	private String id;

	public UserBean() {
		super();
	}

	public UserBean(String username) {
		super();
		this.username = username;
	}

	public UserBean(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public UserBean(String username, String password, String email,
			String phone, String address) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	public UserBean(String username, String password, String password2,
			String email, String phone, String address) {
		super();
		this.username = username;
		this.password = password;
		this.password2 = password2;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	public UserBean(String username, String password, String password2,
			String email, String phone, String address, String id) {
		super();
		this.username = username;
		this.password = password;
		this.password2 = password2;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		String user = this.username + " " + this.password + " " + this.email + " " + this.phone
				+ " " + this.address+" "+this.id;
		return user;
	}

}
