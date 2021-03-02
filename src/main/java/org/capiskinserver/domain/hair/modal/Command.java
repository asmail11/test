package org.capiskinserver.domain.hair.modal;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.capiskinserver.security.model.User;
import org.capiskinserver.util.PersistableElement;

@Entity
@Table(name = "commands")
public class Command extends PersistableElement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String productName;

	private String baseProduct;

	private double total;

	private boolean status;

	
	  @ManyToOne 
	  private User user;
	 
	public Command() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Command(String productName, String baseProduct, double total, boolean status, User user) {
		super();
		this.productName = productName;
		this.baseProduct = baseProduct;
		this.total = total;
		this.status = status;
		this.user = user;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBaseProduct() {
		return baseProduct;
	}

	public void setBaseProduct(String baseProduct) {
		this.baseProduct = baseProduct;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
