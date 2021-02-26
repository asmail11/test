package org.capiskinserver.domain.hair.service;

import java.util.Date;

import org.capiskinserver.domain.hair.dao.VegetableOilDao;
import org.capiskinserver.domain.hair.modal.Characteristic;
import org.capiskinserver.domain.hair.modal.VegetableOil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VegetableOilDomainServiceImpl implements VegetableOilDomainService {

	@Autowired
	private VegetableOilDao vegetableOilDao;

	@Override
	public VegetableOil addVegetableOil(VegetableOil ingrediant, Characteristic characteristic) {
		if (ingrediant != null && characteristic != null) {

			if (characteristic.getType().contains("Bouclés")) {
				ingrediant.setCoco("Coco");
				ingrediant.setBrocoli("Brocoli");
				ingrediant.setPepinDeRisin("Piqui");
			} else if (characteristic.getType().contains("Lisses")) {
				ingrediant.setCoco("Coco");
				ingrediant.setAmandeDouce("Amande Douce");
				ingrediant.setRicin("Ricin");
			} else if (characteristic.getType().contains("Ondulés")) {
				ingrediant.setCoco("OndulÃ©s");
				ingrediant.setPepinDeRisin("Pepin De Raisin");
				ingrediant.setOlive("Olive");
			} else if (characteristic.getType().contains("Frisés")) {
				ingrediant.setAvocat("Avocat");
				ingrediant.setCoco("Coco");
				ingrediant.setSapote("Sapote");
			} else if (characteristic.getType().contains("Grépus")) {
				ingrediant.setBaobab("Baobab");
				ingrediant.setCoco("Coco");
				ingrediant.setBrocoli("Brocoli");
				ingrediant.setMangue("Mangue");
			}

			if (characteristic.getNature().contains("Normaux")) {
				ingrediant.setOlive("Olive");
			} else if (characteristic.getNature().contains("Secs")) {
				ingrediant.setJojoba("Jojoba");
				ingrediant.setArgan("Argan");
			} else if (characteristic.getNature().contains("Très secs")) {
				ingrediant.setKarite("KaritÃ©");
				ingrediant.setOwala("Owala");
			} else if (characteristic.getNature().contains("Gras")) {
				ingrediant.setCoco("Coco");
				ingrediant.setOwala("Owala");
			}

			if (characteristic.getTexture().contains("Fins")) {
				ingrediant.setAmandeDouce("Amande Douce");
				ingrediant.setCoco("Coco");
				ingrediant.setBrocoli("Brocoli");
			} else if (characteristic.getTexture().contains("Moyens")) {
				ingrediant.setOlive("Olive");
			} else if (characteristic.getTexture().contains("Epais")) {
				ingrediant.setMacadamia("Macadamia");
				ingrediant.setCoco("Coco");
				ingrediant.setOwala("Owala");
			}

			if (characteristic.getVisual().contains("Ternes")) {
				ingrediant.setAvocat("Avocat");
				ingrediant.setOwala("Owala");
			} else if (characteristic.getVisual().contains("Normaux")) {
				ingrediant.setOlive("Olive");
			} else if (characteristic.getVisual().contains("Brillant")) {
				ingrediant.setArgan("Argan");
			}

			if (characteristic.getProblem().contains("Pellicules")) {
				ingrediant.setRicin("Ricin");
			} else if (characteristic.getProblem().contains("Chveux gras")) {
				ingrediant.setNigelle("Nigelle");
				ingrediant.setJojoba("Jojoba");
				ingrediant.setNeem("Neem");
			} else if (characteristic.getProblem().contains("Demangeaisons")) {
				ingrediant.setBourrache("Bourrache");
				ingrediant.setCoco("Coco");
				ingrediant.setOwala("Owala");
			} else if (characteristic.getProblem().contains("Cheveux cassants")) {
				ingrediant.setCoco("Coco");
				ingrediant.setArgan("Argan");
			}

			ingrediant.setCreatedAt(new Date());
			characteristic.setVegetableOil(ingrediant);
			ingrediant.setCharacteristic(characteristic);
			return vegetableOilDao.save(ingrediant);
		}
		return null;
	}

	@Override
	public VegetableOil editVegetableOil(VegetableOil vegetableOil, VegetableOil existVegetableOil) {
		if (vegetableOil != null && existVegetableOil != null) {
			existVegetableOil.setCreatedAt(null);
			existVegetableOil.setUpdatedAt(new Date());
			return vegetableOilDao.save(existVegetableOil);
		}
		return null;
	}

}
