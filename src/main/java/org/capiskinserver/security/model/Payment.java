package org.capiskinserver.security.model;

import javax.persistence.Column;
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
@Table(name = "payments")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotBlank
	@NotNull
	@NotEmpty
	@Size(min = 4, max = 50)
	private String nameOnCard;
	
	private String cartNumber;
	
	@Column(length = 3000)
	private String expiry;
	
	private int cryptogram;

	@OneToOne
	private User user;

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(long id, String nameOnCard, String cartNumber, String expiry, int cryptogram, User user) {
		super();
		this.id = id;
		this.nameOnCard = nameOnCard;
		this.cartNumber = cartNumber;
		this.expiry = expiry;
		this.cryptogram = cryptogram;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public String getCartNumber() {
		return cartNumber;
	}

	public void setCartNumber(String cartNumber) {
		this.cartNumber = cartNumber;
	}

	public String getExpiry() {
		return expiry;
	}

	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}

	public int getCryptogram() {
		return cryptogram;
	}

	public void setCryptogram(int cryptogram) {
		this.cryptogram = cryptogram;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
