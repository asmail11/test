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
import org.capiskinserver.security.modal.User;

@Entity
@Table(name = "categories")
public class Category extends PersistableElement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotBlank
	@Size(min = 3, max = 50)
	@Column(unique = true)
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category", orphanRemoval = true)
	private List<BodyAndHair> bodyAndHairs;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category", orphanRemoval = true)
	private List<Characteristic> characteristics;

	@ManyToOne
	private User user;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(String name, List<BodyAndHair> bodyAndHairs, List<Characteristic> characteristics, User user) {
		super();
		this.name = name;
		this.bodyAndHairs = bodyAndHairs;
		this.characteristics = characteristics;
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<BodyAndHair> getBodyAndHairs() {
		return bodyAndHairs;
	}

	public void setBodyAndHairs(List<BodyAndHair> bodyAndHairs) {
		this.bodyAndHairs = bodyAndHairs;
	}

	public List<Characteristic> getCharacteristics() {
		return characteristics;
	}

	public void setCharacteristics(List<Characteristic> characteristics) {
		this.characteristics = characteristics;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void addBodyAndHair(BodyAndHair bodyAndHair) {
		if (getBodyAndHairs() == null) {
			this.bodyAndHairs = new ArrayList<>();
		}
		getBodyAndHairs().add(bodyAndHair);
		bodyAndHair.setCategory(this);
	}

	public boolean hasBodyAndHair(String name) {
		if (getBodyAndHairs() != null) {
			return getBodyAndHairs().stream()
					.filter(bodyAndHairs -> bodyAndHairs.getName().toLowerCase().equals(name.toLowerCase())).findAny()
					.orElse(null) != null;
		}
		return false;
	}

	public void addCharacteristic(Characteristic characteristic) {
		if (getCharacteristics() == null) {
			this.characteristics = new ArrayList<>();
		}
		getCharacteristics().add(characteristic);
		characteristic.setCategory(this);
	}

	public boolean hasCharacteristicType(String type) {
		if (getCharacteristics() != null) {
			return getCharacteristics().stream()
					.filter(characteristics -> characteristics.getType().toLowerCase().equals(type.toLowerCase()))
					.findAny().orElse(null) != null;
		}
		return false;
	}

	public boolean hasCharacteristicNature(String nature) {
		if (getCharacteristics() != null) {
			return getCharacteristics().stream()
					.filter(characteristics -> characteristics.getNature().toLowerCase().equals(nature.toLowerCase()))
					.findAny().orElse(null) != null;
		}
		return false;
	}

	public boolean hasCharacteristicTexture(String texture) {
		if (getCharacteristics() != null) {
			return getCharacteristics().stream()
					.filter(characteristics -> characteristics.getTexture().toLowerCase().equals(texture.toLowerCase()))
					.findAny().orElse(null) != null;
		}
		return false;
	}

	public boolean hasCharacteristicTreatment(String treatment) {
		if (getCharacteristics() != null) {
			return getCharacteristics().stream().filter(
					characteristics -> characteristics.getTreatment().toLowerCase().equals(treatment.toLowerCase()))
					.findAny().orElse(null) != null;
		}
		return false;
	}

	public boolean hasCharacteristicVisual(String visual) {
		if (getCharacteristics() != null) {
			return getCharacteristics().stream()
					.filter(characteristics -> characteristics.getVisual().toLowerCase().equals(visual.toLowerCase()))
					.findAny().orElse(null) != null;
		}
		return false;
	}

	public boolean hasCharacteristicProblem(String problem) {
		if (getCharacteristics() != null) {
			return getCharacteristics().stream()
					.filter(characteristics -> characteristics.getProblem().toLowerCase().equals(problem.toLowerCase()))
					.findAny().orElse(null) != null;
		}
		return false;
	}
}
