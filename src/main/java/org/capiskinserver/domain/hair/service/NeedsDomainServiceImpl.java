package org.capiskinserver.domain.hair.service;

import java.util.Date;

import org.capiskinserver.domain.hair.dao.NeedsDao;
import org.capiskinserver.domain.hair.modal.Characteristic;
import org.capiskinserver.domain.hair.modal.Needs;
import org.capiskinserver.exception.AlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NeedsDomainServiceImpl implements NeedsDomainService {
	
	@Autowired
	private NeedsDao needsDao;

	@Override
	public Needs addNeeds(Needs needs, Characteristic characteristic) {
		if (characteristic.hasNeeds(needs.getName())) {
			throw new AlreadyExistsException("\n The characteristic of characteristic has be unique \n");
		}
		if (needs!=null && characteristic!=null) {
			needs.setCreatedAt(new Date());
			characteristic.addNeeds(needs);
			return needsDao.save(needs);
		}
		return null;
	}

	@Override
	public Needs editNeeds(Needs needs, Needs existNeeds) {
		if (needs!=null && existNeeds!=null) {
			existNeeds.setCreatedAt(null);
			existNeeds.setUpdatedAt(new Date());
			existNeeds.setName(needs.getName());
			existNeeds.setPhoto(needs.getPhoto());
			existNeeds.setDescription(needs.getDescription());
			return needsDao.save(existNeeds);
		}
		return null;
	}
	
	

}
