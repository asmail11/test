package org.capiskinserver.domain.hair.modal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.capiskinserver.util.PersistableElement;

@Entity
@Table(name = "bodyAndHairs")
public class BodyAndHair extends PersistableElement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotBlank
	@Size(min = 3, max = 50)
	@Column(unique = true)
	private String name;

	@ManyToOne
	private Category category;

	@OneToMany(cascade = CascadeType.ALL)
	private List<FaceAndCare> faceAndCares;

	public BodyAndHair() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BodyAndHair(String name, Category category, List<FaceAndCare> faceAndCares) {
		super();
		this.name = name;
		this.category = category;
		this.faceAndCares = faceAndCares;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<FaceAndCare> getFaceAndCares() {
		return faceAndCares;
	}

	public void setFaceAndCares(List<FaceAndCare> faceAndCares) {
		this.faceAndCares = faceAndCares;
	}

	public void addFaceAndCare(FaceAndCare faceAndCare) {
		if (getFaceAndCares() == null) {
			this.faceAndCares = new ArrayList<>();
		}
		getFaceAndCares().add(faceAndCare);
		faceAndCare.setBodyAndHair(this);
	}

	public boolean hasFaceAndCare(String name) {
		if (getFaceAndCares() != null) {
			return getFaceAndCares().stream()
					.filter(faceAndCares -> faceAndCares.getName().toLowerCase().equals(name.toLowerCase())).findAny()
					.orElse(null) != null;
		}
		return false;
	}

}
