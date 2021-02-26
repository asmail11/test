package org.capiskinserver.domain.hair.modal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.capiskinserver.config.PersistableElement;

@Entity
@Table(name = "ContentMillimiters")
public class ContentMillimiter extends PersistableElement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int smallMillimiter;

	private int meduimMillimiter;

	private int bigMillimiter;

	private double smallPrice;

	private double meduimPrice;

	private double bigPrice;

	@OneToOne(cascade = CascadeType.ALL)
	private FinalProduct finalProduct;

	public ContentMillimiter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContentMillimiter(int smallMillimiter, int meduimMillimiter, int bigMillimiter, double smallPrice,
			double meduimPrice, double bigPrice, FinalProduct finalProduct) {
		super();
		this.smallMillimiter = smallMillimiter;
		this.meduimMillimiter = meduimMillimiter;
		this.bigMillimiter = bigMillimiter;
		this.smallPrice = smallPrice;
		this.meduimPrice = meduimPrice;
		this.bigPrice = bigPrice;
		this.finalProduct = finalProduct;
	}

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

	public FinalProduct getFinalProduct() {
		return finalProduct;
	}

	public void setFinalProduct(FinalProduct finalProduct) {
		this.finalProduct = finalProduct;
	}

}
