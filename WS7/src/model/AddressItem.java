package model;

/**
 * this class represent a single address object, with several key attributes
 * @author Siran
 *
 */
public class AddressItem {
	
	private String name;
	private String street;
	private String city;
	private String province;
	private String postCode;
	
	
	public AddressItem(String name, String street, String city, String province, String postCode) {
		this.name = name;
		this.setStreet(street);
		this.setCity(city);
		this.setProvince(province);
		this.setPostCode(postCode);
	}
	
	
	/**
	 * this override method return the name of the address
	 */
	@Override
	public String toString() {
		return name;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getProvince() {
		return province;
	}


	public void setProvince(String province) {
		this.province = province;
	}


	public String getPostCode() {
		return postCode;
	}


	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

}
