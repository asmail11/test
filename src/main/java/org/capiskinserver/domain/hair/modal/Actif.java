package org.capiskinserver.domain.hair.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.capiskinserver.config.PersistableElement;

@Entity
@Table(name = "actifs")
public class Actif extends PersistableElement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotBlank
	@Size(min = 3, max = 50)
	@Column(unique = true)
	private String name;

	@OneToOne
	private Characteristic characteristic;

	public Actif() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Actif(String name, Characteristic characteristic) {
		super();
		this.name = name;
		this.characteristic = characteristic;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Characteristic getCharacteristic() {
		return characteristic;
	}

	public void setCharacteristic(Characteristic characteristic) {
		this.characteristic = characteristic;
	}

}
