package org.capiskinserver.security.model;

public class PaymentDto {
	
	private long id;
	
	private String nameOnCard;
	
	private String cartNumber;
	
	private String expiry;
	
	private int cryptogram;

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
	
	

}
