package org.capiskinserver.security.model;

public class AccountDto {
	
	private long id;
	
	private String name;
	
	private String address;
	
	private String gender;
	
	private String city;
	
	private String codePostale;
	
	private String phone;
	
	private String conditionAccept;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCodePostale() {
		return codePostale;
	}

	public void setCodePostale(String codePostale) {
		this.codePostale = codePostale;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getConditionAccept() {
		return conditionAccept;
	}

	public void setConditionAccept(String conditionAccept) {
		this.conditionAccept = conditionAccept;
	}
    
	

}
