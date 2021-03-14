package org.capiskinserver.application.hair.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.capiskinserver.application.hair.dto.ActifDto;
import org.capiskinserver.domain.hair.OrikaBeanMapper;
import org.capiskinserver.domain.hair.dao.ActifDao;

import org.capiskinserver.domain.hair.modal.Actif;
import org.capiskinserver.domain.hair.service.ActifDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ActifManagerServiceImpl implements ActifManagerService {

	private final OrikaBeanMapper orikaBeanMapper;

	private final ActifDomainService actifDomainService;

	private final ActifDao actifDao;

	@Autowired
	public ActifManagerServiceImpl(OrikaBeanMapper orikaBeanMapper, ActifDomainService actifDomainService,
		 ActifDao actifDao) {
		super();
		this.orikaBeanMapper = orikaBeanMapper;
		this.actifDomainService = actifDomainService;
		this.actifDao = actifDao;
	}

	@Override
	public ActifDto addActif(ActifDto actifDto) {
		Actif actif = orikaBeanMapper.map(actifDto, Actif.class);
		return orikaBeanMapper.convertDTO(actifDomainService.addActif(actif), ActifDto.class);
	}

	@Override
	public ActifDto editActif(ActifDto actifDto, long idActif) {
		Actif actif = orikaBeanMapper.map(actifDto, Actif.class);
		Actif existActif = actifDao.getOne(idActif);
		return orikaBeanMapper.convertDTO(actifDomainService.editActif(actif, existActif), ActifDto.class);
	}

	@Override
	public ActifDto findActif(long idActif) {
		return orikaBeanMapper.convertDTO(actifDao.getOne(idActif), ActifDto.class);
	}


	@Override
	public void deleteActif(long idActif) {
		Actif existActif = actifDao.getOne(idActif);
		actifDao.delete(existActif);
	}

	@Override
	public Boolean actifNameExists(String checkedName) {
		return actifDao.existsByName(checkedName);
	}

	@Override
	public List<ActifDto> finActifs() {
		List<Actif> actifs = actifDao.findAll();
		actifs = actifs.stream().sorted(Comparator.comparing(Actif::getName))
				.collect(Collectors.toList());
		return orikaBeanMapper.convertListDTO(actifs, ActifDto.class);
	}

}
