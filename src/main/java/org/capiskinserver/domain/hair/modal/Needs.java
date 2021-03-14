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
@Table(name = "needs")
public class Needs extends PersistableElement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "need", orphanRemoval = true)
	private List<BaseProduct> baseProducts;

	@ManyToOne
	private Characteristic characteristic;

	public Needs() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Needs(List<BaseProduct> baseProducts, Characteristic characteristic) {
		super();
		this.baseProducts = baseProducts;
		this.characteristic = characteristic;
	}

	public Characteristic getCharacteristic() {
		return characteristic;
	}

	public void setCharacteristic(Characteristic characteristic) {
		this.characteristic = characteristic;
	}

	public List<BaseProduct> getBaseProducts() {
		return baseProducts;
	}

	public void setBaseProducts(List<BaseProduct> baseProducts) {
		this.baseProducts = baseProducts;
	}

	public void addBaseProduct(BaseProduct baseProduct) {
		if (getBaseProducts() == null) {
			this.baseProducts = new ArrayList<>();
		}
		getBaseProducts().add(baseProduct);
		baseProduct.setNeed(this);
	}

	public boolean hasBaseProduct(String name) {
		if (getBaseProducts() != null) {
			return getBaseProducts().stream()
					.filter(baseProducts -> baseProducts.getName().toLowerCase().equals(name.toLowerCase())).findAny()
					.orElse(null) != null;
		}
		return false;
	}
}
