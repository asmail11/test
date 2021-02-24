package org.capiskinserver.domain.hair.modal;

import javax.persistence.Entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


public class Category {
	
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category(String name) {
		super();
		this.name = name;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
