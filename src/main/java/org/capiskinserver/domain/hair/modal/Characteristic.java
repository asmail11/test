package org.capiskinserver.domain.hair.modal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.capiskinserver.config.PersistableElement;

@Entity
@Table(name = "characteristics")
public class Characteristic extends PersistableElement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotBlank
	@Size(min = 3, max = 50)
	@Column(unique = true)
	private String type;

	@NotBlank
	@Size(min = 3, max = 50)
	@Column(unique = true)
	private String nature;

	@NotBlank
	@Size(min = 3, max = 50)
	@Column(unique = true)
	private String texture;

	@NotBlank
	@Size(min = 3, max = 50)
	@Column(unique = true)
	private String treatment;

	@NotBlank
	@Size(min = 3, max = 50)
	@Column(unique = true)
	private String visual;

	@NotBlank
	@Size(min = 3, max = 50)
	@Column(unique = true)
	private String problem;

	@NotBlank
	@Size(min = 3, max = 50)
	@Column(unique = true)
	private String photo;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "characteristic", orphanRemoval = true)
	private List<Needs> needs;

	@ManyToOne
	private Category category;

	@OneToOne(cascade = CascadeType.ALL)
	private EssentialOil essentialOil;

	@OneToOne(cascade = CascadeType.ALL)
	private Actif actif;

	@OneToOne(cascade = CascadeType.ALL)
	private VegetableOil vegetableOil;

	public Characteristic() {
		super();
	}

	public Characteristic(String type, String nature, String texture, String treatment, String visual, String problem,
			String photo, List<Needs> needs, Category category, EssentialOil essentialOil, Actif actif,
			VegetableOil vegetableOil) {
		super();
		this.type = type;
		this.nature = nature;
		this.texture = texture;
		this.treatment = treatment;
		this.visual = visual;
		this.problem = problem;
		this.photo = photo;
		this.needs = needs;
		this.category = category;
		this.essentialOil = essentialOil;
		this.actif = actif;
		this.vegetableOil = vegetableOil;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public String getTexture() {
		return texture;
	}

	public void setTexture(String texture) {
		this.texture = texture;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	public String getVisual() {
		return visual;
	}

	public void setVisual(String visual) {
		this.visual = visual;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public List<Needs> getNeeds() {
		return needs;
	}

	public void setNeeds(List<Needs> needs) {
		this.needs = needs;
	}

	public EssentialOil getEssentialOil() {
		return essentialOil;
	}

	public void setEssentialOil(EssentialOil essentialOil) {
		this.essentialOil = essentialOil;
	}

	public Actif getActif() {
		return actif;
	}

	public void setActif(Actif actif) {
		this.actif = actif;
	}

	public VegetableOil getVegetableOil() {
		return vegetableOil;
	}

	public void setVegetableOil(VegetableOil vegetableOil) {
		this.vegetableOil = vegetableOil;
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

}
