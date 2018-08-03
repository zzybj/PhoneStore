package zzy.phoneStore.bean;

import java.sql.Blob;

public class PhoneBean {

	private String phonename;
	private double price;
	private Blob image;
	private String address;
	private int num;
	private String itcalss;

	public PhoneBean() {
		super();
	}

	public PhoneBean(String phonename, double price, Blob image, String address) {
		super();
		this.phonename = phonename;
		this.price = price;
		this.image = image;
		this.address = address;
	}

	public PhoneBean(String phonename, double price, Blob image,
			String address, int num) {
		super();
		this.phonename = phonename;
		this.price = price;
		this.image = image;
		this.address = address;
		this.num = num;
	}

	public PhoneBean(String phonename, double price, Blob image,
			String address, int num, String itcalss) {
		super();
		this.phonename = phonename;
		this.price = price;
		this.image = image;
		this.address = address;
		this.num = num;
		this.itcalss = itcalss;
	}

	public String getItcalss() {
		return itcalss;
	}

	public void setItcalss(String itcalss) {
		this.itcalss = itcalss;
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

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	@Override
	public String toString() {
		String str = " "+ phonename+" "+ price +" "+ image+" "+address+" "+ num+" "+ itcalss;
		return str;
	}

	
	
}
