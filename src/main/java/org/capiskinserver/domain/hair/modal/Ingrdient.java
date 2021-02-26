package org.capiskinserver.domain.hair.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.capiskinserver.config.PersistableElement;

@Entity
@Table(name = "ingrdients")
public class Ingrdient extends PersistableElement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotBlank
	@Size(min = 3, max = 50)
	@Column(unique = true)
	private String name;
	
	@ManyToOne
	private FaceAndCare faceAndCare;

	public Ingrdient() {
		super();
	}

	public Ingrdient(String name, FaceAndCare faceAndCare) {
		super();
		this.name = name;
		this.faceAndCare = faceAndCare;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FaceAndCare getFaceAndCare() {
		return faceAndCare;
	}

	public void setFaceAndCare(FaceAndCare faceAndCare) {
		this.faceAndCare = faceAndCare;
	}
	
	

}
