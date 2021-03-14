package org.capiskinserver.security.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user_accounts")
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 50)
	private String name;
	
	@NotBlank
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 100)
	private String address;
	
	@NotBlank
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 50)
	private String gender;
	
	@NotBlank
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 50)
	private String city;
	
	@NotBlank
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 50)
	private String codePostale;
	
	@NotBlank
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 50)
	private String phone;
	
	@NotBlank
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 50)
	private String conditionAccept;

	@OneToOne(cascade = CascadeType.MERGE)
	private User user;

	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(String name, String address, String gender, String city, String codePostale, String phone,
			String conditionAccept, User user) {
		super();
		this.name = name;
		this.address = address;
		this.gender = gender;
		this.city = city;
		this.codePostale = codePostale;
		this.phone = phone;
		this.conditionAccept = conditionAccept;
		this.user = user;
	}


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

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	

}
