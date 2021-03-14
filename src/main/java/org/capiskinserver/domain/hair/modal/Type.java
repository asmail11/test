package org.capiskinserver.domain.hair.modal;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.capiskinserver.util.PersistableElement;

@Entity
@Table(name = "types")
public class Type extends PersistableElement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "type", orphanRemoval = true)
	private List<Characteristic> characteristics;

	@ManyToOne
	private BodyFaceHair bodyFaceHair;

	public Type() {
		super();
	}

	public Type(List<Characteristic> characteristics, BodyFaceHair bodyFaceHair,
			 String photo) {
		super();
		this.characteristics = characteristics;
		this.bodyFaceHair = bodyFaceHair;
	}

	public List<Characteristic> getCharacteristics() {
		return characteristics;
	}

	public void setCharacteristics(List<Characteristic> characteristics) {
		this.characteristics = characteristics;
	}

	public BodyFaceHair getBodyFaceHair() {
		return bodyFaceHair;
	}

	public void setBodyFaceHair(BodyFaceHair bodyFaceHair) {
		this.bodyFaceHair = bodyFaceHair;
	}

	public void addCharacteristic(Characteristic characteristic) {
		if (getCharacteristics() == null) {
			this.characteristics = new ArrayList<>();
		}
		getCharacteristics().add(characteristic);
		characteristic.setType(this);
	}

	public boolean hasCharacteristicName(String name) {
		if (getCharacteristics() != null) {
			return getCharacteristics().stream()
					.filter(characteristics -> characteristics.getName().toLowerCase().equals(name.toLowerCase()))
					.findAny().orElse(null) != null;
		}
		return false;
	}

}
