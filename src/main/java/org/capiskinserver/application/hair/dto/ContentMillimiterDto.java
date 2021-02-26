package org.capiskinserver.application.hair.dto;

public class ContentMillimiterDto extends PersistableElementDto {
	
	private int smallMillimiter;

	private int meduimMillimiter;

	private int bigMillimiter;

	private double smallPrice;

	private double meduimPrice;

	private double bigPrice;

	public int getSmallMillimiter() {
		return smallMillimiter;
	}

	public void setSmallMillimiter(int smallMillimiter) {
		this.smallMillimiter = smallMillimiter;
	}

	public int getMeduimMillimiter() {
		return meduimMillimiter;
	}

	public void setMeduimMillimiter(int meduimMillimiter) {
		this.meduimMillimiter = meduimMillimiter;
	}

	public int getBigMillimiter() {
		return bigMillimiter;
	}

	public void setBigMillimiter(int bigMillimiter) {
		this.bigMillimiter = bigMillimiter;
	}

	public double getSmallPrice() {
		return smallPrice;
	}

	public void setSmallPrice(double smallPrice) {
		this.smallPrice = smallPrice;
	}

	public double getMeduimPrice() {
		return meduimPrice;
	}

	public void setMeduimPrice(double meduimPrice) {
		this.meduimPrice = meduimPrice;
	}

	public double getBigPrice() {
		return bigPrice;
	}

	public void setBigPrice(double bigPrice) {
		this.bigPrice = bigPrice;
	}
	
	

}
