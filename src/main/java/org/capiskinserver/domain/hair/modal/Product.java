package org.capiskinserver.domain.hair.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.capiskinserver.util.PersistableElement;

@Entity
@Table(name = "products")
public class Product extends PersistableElement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	    @Column(name = "name", unique = true)
	    private String name;
	    
		private String photo;

		private double price;
     
		public Product() {
			super();
		}

		public Product(String name, String photo, double price) {
			super();
			this.name = name;
			this.photo = photo;
			this.price = price;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPhoto() {
			return photo;
		}

		public void setPhoto(String photo) {
			this.photo = photo;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}
		    	    

}
