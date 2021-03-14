package org.capiskinserver.application.hair.dto;

public class ProductDto extends PersistableElementDto {
	
    private String name;
    
	private String photo;

	private double price;

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
