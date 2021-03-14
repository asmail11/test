package org.capiskinserver.domain.hair.modal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.capiskinserver.util.PersistableElement;

@Entity
@Table(name = "characteristics")
public class Characteristic extends PersistableElement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToMany(fetch = FetchType.LAZY)
	private List<EssentialOil> essentialOils;

	@ManyToMany(fetch = FetchType.LAZY)
	private List<Actif> actifs;

	@ManyToMany(fetch = FetchType.LAZY)
	private List<Ingredient> products;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "characteristic", orphanRemoval = true)
	private List<Needs> needs;

	@ManyToOne
	private Type type;

	public Characteristic() {
		super();
	}

	public Characteristic(List<EssentialOil> essentialOils,
			List<Actif> actifs, List<Ingredient> products, List<Needs> needs, Type type, String photo) {
		super();
		this.essentialOils = essentialOils;
		this.actifs = actifs;
		this.products = products;
		this.needs = needs;
		this.type = type;
	}

	public List<EssentialOil> getEssentialOils() {
		return essentialOils;
	}

	public void setEssentialOils(List<EssentialOil> essentialOils) {
		this.essentialOils = essentialOils;
	}

	public List<Actif> getActifs() {
		return actifs;
	}

	public void setActifs(List<Actif> actifs) {
		this.actifs = actifs;
	}

	public List<Ingredient> getProducts() {
		return products;
	}

	public void setProducts(List<Ingredient> products) {
		this.products = products;
	}

	public List<Needs> getNeeds() {
		return needs;
	}

	public void setNeeds(List<Needs> needs) {
		this.needs = needs;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public void addNeeds(Needs needs) {
		if (getNeeds() == null) {
			this.needs = new ArrayList<>();
		}
		getNeeds().add(needs);
		needs.setCharacteristic(this);
	}

	public boolean hasNeeds(String name) {
		if (getNeeds() != null) {
			return getNeeds().stream().filter(needs -> needs.getName().toLowerCase().equals(name.toLowerCase()))
					.findAny().orElse(null) != null;
		}
		return false;
	}

	public void addEssentialOilForCharacteristic(EssentialOil essentialOil) {
		if (getEssentialOils() == null) {
			this.essentialOils = new ArrayList<>();

		}
		if (!getEssentialOils().contains(essentialOil)) {
			getEssentialOils().add(essentialOil);
		}
	}

	public void addProductForCharacteristic(Ingredient product) {
		if (getProducts() == null) {
			this.products = new ArrayList<>();
		}
		if (!getProducts().contains(product)) {
			getProducts().add(product);
		}
	}

	public void addActifForCharacteristic(Actif actif) {
		if (getActifs() == null) {
			this.actifs = new ArrayList<>();
		}
		if (!getActifs().contains(actif)) {
			getActifs().add(actif);
		}
	}

}
