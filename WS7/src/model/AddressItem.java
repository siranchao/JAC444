package model;

/**
 * this class represent a single address object, with several key attributes
 * @author Siran
 *
 */
public class AddressItem {
	
	public String name;
	private String street;
	private String city;
	private String province;
	private String postCode;
	private String name2;
	private String street2;
	private String city2;
	private String province2;
	private String postCode2;
	
	
	public AddressItem(String name, String street, String city, String province, String postCode, String name2, String street2, String city2, String province2, String postCode2) {
		this.name = name;
		this.setStreet(street);
		this.setCity(city);
		this.setProvince(province);
		this.setPostCode(postCode);
		this.setName2(name2);
		this.setStreet2(street2);
		this.setCity2(city2);
		this.setProvince2(province2);
		this.setPostCode2(postCode2);
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


	public String getStreet2() {
		return street2;
	}


	public void setStreet2(String street2) {
		this.street2 = street2;
	}


	public String getName2() {
		return name2;
	}


	public void setName2(String name2) {
		this.name2 = name2;
	}


	public String getCity2() {
		return city2;
	}


	public void setCity2(String city2) {
		this.city2 = city2;
	}


	public String getProvince2() {
		return province2;
	}


	public void setProvince2(String province2) {
		this.province2 = province2;
	}


	public String getPostCode2() {
		return postCode2;
	}


	public void setPostCode2(String postCode2) {
		this.postCode2 = postCode2;
	}

}
