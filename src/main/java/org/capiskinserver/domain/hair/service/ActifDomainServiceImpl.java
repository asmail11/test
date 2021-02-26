package org.capiskinserver.domain.hair.service;

import java.util.Date;

import org.capiskinserver.domain.hair.dao.ActifDao;
import org.capiskinserver.domain.hair.modal.Actif;
import org.capiskinserver.domain.hair.modal.Characteristic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActifDomainServiceImpl implements ActifDomainService {

	@Autowired
	private ActifDao actifDao;

	@Override
	public Actif addActif(Actif actif, Characteristic characteristic) {
		if (actif != null && characteristic != null) {
			actif.setCreatedAt(new Date());
			actif.setCharacteristic(characteristic);
			characteristic.setActif(actif);
			return actifDao.save(actif);
		}
		return null;
	}

	@Override
	public Actif editActif(Actif actif, Actif existActif) {
		if (actif != null && existActif != null) {
			existActif.setCreatedAt(null);
			actif.setUpdatedAt(new Date());
			existActif.setName(actif.getName());
			existActif.setDescription(actif.getDescription());
			return actifDao.save(existActif);
		}
		return null;
	}

}
