package org.capiskinserver.domain.hair.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.capiskinserver.config.PersistableElement;

@Entity
@Table(name = "vegetableOils")
public class VegetableOil extends PersistableElement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(unique = true)
	private String amandeDouce;
	@Column(unique = true)
	private String coco;
	@Column(unique = true)
	private String ricin;
	@Column(unique = true)
	private String karite;
	@Column(unique = true)
	private String pepinDeRisin;
	@Column(unique = true)
	private String olive;
	@Column(unique = true)
	private String brocoli;
	@Column(unique = true)
	private String piqui;
	@Column(unique = true)
	private String avocat;
	@Column(unique = true)
	private String sapote;
	@Column(unique = true)
	private String baobab;
	@Column(unique = true)
	private String mangue;
	@Column(unique = true)
	private String macadamia;
	@Column(unique = true)
	private String owala;
	@Column(unique = true)
	private String jojoba;
	@Column(unique = true)
	private String nigelle;
	@Column(unique = true)
	private String neem;
	@Column(unique = true)
	private String bourrache;
	@Column(unique = true)
	private String argan;

	private String photo;

	private double price;

	@OneToOne
	private Characteristic characteristic;

	public VegetableOil() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VegetableOil(String amandeDouce, String coco, String ricin, String karite, String pepinDeRisin, String olive,
			String brocoli, String piqui, String avocat, String sapote, String baobab, String mangue, String macadamia,
			String owala, String jojoba, String nigelle, String neem, String bourrache, String argan, String photo,
			double price, Characteristic characteristic) {
		super();
		this.amandeDouce = amandeDouce;
		this.coco = coco;
		this.ricin = ricin;
		this.karite = karite;
		this.pepinDeRisin = pepinDeRisin;
		this.olive = olive;
		this.brocoli = brocoli;
		this.piqui = piqui;
		this.avocat = avocat;
		this.sapote = sapote;
		this.baobab = baobab;
		this.mangue = mangue;
		this.macadamia = macadamia;
		this.owala = owala;
		this.jojoba = jojoba;
		this.nigelle = nigelle;
		this.neem = neem;
		this.bourrache = bourrache;
		this.argan = argan;
		this.photo = photo;
		this.price = price;
		this.characteristic = characteristic;
	}

	public String getAmandeDouce() {
		return amandeDouce;
	}

	public void setAmandeDouce(String amandeDouce) {
		this.amandeDouce = amandeDouce;
	}

	public String getCoco() {
		return coco;
	}

	public void setCoco(String coco) {
		this.coco = coco;
	}

	public String getRicin() {
		return ricin;
	}

	public void setRicin(String ricin) {
		this.ricin = ricin;
	}

	public String getKarite() {
		return karite;
	}

	public void setKarite(String karite) {
		this.karite = karite;
	}

	public String getPepinDeRisin() {
		return pepinDeRisin;
	}

	public void setPepinDeRisin(String pepinDeRisin) {
		this.pepinDeRisin = pepinDeRisin;
	}

	public String getOlive() {
		return olive;
	}

	public void setOlive(String olive) {
		this.olive = olive;
	}

	public String getBrocoli() {
		return brocoli;
	}

	public void setBrocoli(String brocoli) {
		this.brocoli = brocoli;
	}

	public String getPiqui() {
		return piqui;
	}

	public void setPiqui(String piqui) {
		this.piqui = piqui;
	}

	public String getAvocat() {
		return avocat;
	}

	public void setAvocat(String avocat) {
		this.avocat = avocat;
	}

	public String getSapote() {
		return sapote;
	}

	public void setSapote(String sapote) {
		this.sapote = sapote;
	}

	public String getBaobab() {
		return baobab;
	}

	public void setBaobab(String baobab) {
		this.baobab = baobab;
	}

	public String getMangue() {
		return mangue;
	}

	public void setMangue(String mangue) {
		this.mangue = mangue;
	}

	public String getMacadamia() {
		return macadamia;
	}

	public void setMacadamia(String macadamia) {
		this.macadamia = macadamia;
	}

	public String getOwala() {
		return owala;
	}

	public void setOwala(String owala) {
		this.owala = owala;
	}

	public String getJojoba() {
		return jojoba;
	}

	public void setJojoba(String jojoba) {
		this.jojoba = jojoba;
	}

	public String getNigelle() {
		return nigelle;
	}

	public void setNigelle(String nigelle) {
		this.nigelle = nigelle;
	}

	public String getNeem() {
		return neem;
	}

	public void setNeem(String neem) {
		this.neem = neem;
	}

	public String getBourrache() {
		return bourrache;
	}

	public void setBourrache(String bourrache) {
		this.bourrache = bourrache;
	}

	public String getArgan() {
		return argan;
	}

	public void setArgan(String argan) {
		this.argan = argan;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Characteristic getCharacteristic() {
		return characteristic;
	}

	public void setCharacteristic(Characteristic characteristic) {
		this.characteristic = characteristic;
	}

}
