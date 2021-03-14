package org.capiskinserver.domain.hair.service;

import java.util.Date;

import org.capiskinserver.domain.hair.dao.EssentialOilDao;
import org.capiskinserver.domain.hair.modal.EssentialOil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EssentialOilDomainServiceImpl implements EssentialOilDomainService {

	@Autowired
	private EssentialOilDao essentialOilDao;

	@Override
	public EssentialOil addEssentialOil(EssentialOil essentialOil) {
		if (essentialOil != null) {
			essentialOil.setCreatedAt(new Date());
			return essentialOilDao.save(essentialOil);
		}
		return null;
	}

	@Override
	public EssentialOil editEssentialOil(EssentialOil essentialOil, EssentialOil existEssentialOil) {
		if (essentialOil != null && existEssentialOil != null) {
			existEssentialOil.setCreatedAt(null);
			existEssentialOil.setUpdatedAt(new Date());
			existEssentialOil.setName(essentialOil.getName());
			existEssentialOil.setDescription(essentialOil.getDescription());
			return essentialOilDao.save(existEssentialOil);
		}
		return null;
	}

}
