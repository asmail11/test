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

import org.capiskinserver.config.PersistableElement;

@Entity
@Table(name = "faceAndCares")
public class FaceAndCare extends PersistableElement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotBlank
	@Size(min = 3, max = 50)
	@Column(unique = true)
	private String name;

	@ManyToOne
	private BodyAndHair bodyAndHair;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "faceAndCare", orphanRemoval = true)
	private List<Ingredient> ingredients;

	public FaceAndCare() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FaceAndCare(String name, BodyAndHair bodyAndHair, List<Ingredient> ingredients) {
		super();
		this.name = name;
		this.bodyAndHair = bodyAndHair;
		this.ingredients = ingredients;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BodyAndHair getBodyAndHair() {
		return bodyAndHair;
	}

	public void setBodyAndHair(BodyAndHair bodyAndHair) {
		this.bodyAndHair = bodyAndHair;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngrdients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public void addIngrdient(Ingredient ingrdient) {
		if (getIngredients() == null) {
			this.ingredients = new ArrayList<>();
		}
		getIngredients().add(ingrdient);
		ingrdient.setFaceAndCare(this);
	}

	public boolean hasIngredient(String name) {
		if (getIngredients() != null) {
			return getIngredients().stream()
					.filter(ingrdients -> ingrdients.getName().toLowerCase().equals(name.toLowerCase())).findAny()
					.orElse(null) != null;
		}
		return false;
	}
}
