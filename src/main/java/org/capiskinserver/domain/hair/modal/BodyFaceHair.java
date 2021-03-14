package org.capiskinserver.domain.hair.modal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.capiskinserver.util.PersistableElement;

@Entity
@Table(name = "bodyFaceHairs")
public class BodyFaceHair extends PersistableElement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "bodyFaceHair", orphanRemoval = true)
	private List<Type> types;

	public BodyFaceHair() {
		super();
		// TODO Auto-generated constructor stub
	}

  
	public BodyFaceHair(List<Type> types) {
		super();
		this.types = types;
	}

	public List<Type> getTypes() {
		return types;
	}

	public void setTypes(List<Type> types) {
		this.types = types;
	}

	public void addType(Type type) {
		if (getTypes() == null) {
			this.types = new ArrayList<>();
		}
		getTypes().add(type);
		type.setBodyFaceHair(this);
	}

	public boolean hasType(String name) {
		if (getTypes() != null) {
			return getTypes().stream()
					.filter(faceAndCares -> faceAndCares.getName().toLowerCase().equals(name.toLowerCase())).findAny()
					.orElse(null) != null;
		}
		return false;
	}

}
