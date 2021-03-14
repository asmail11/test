package org.capiskinserver.application.hair.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.capiskinserver.application.hair.dto.EssentialOilDto;
import org.capiskinserver.domain.hair.OrikaBeanMapper;
import org.capiskinserver.domain.hair.dao.EssentialOilDao;
import org.capiskinserver.domain.hair.modal.EssentialOil;
import org.capiskinserver.domain.hair.service.EssentialOilDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EssentialOilManagerServiceImpl implements EssentialOilManagerService {

	private EssentialOilDao essentialOilDao;

	private EssentialOilDomainService essentialOilDomainService;

	private OrikaBeanMapper orikaBeanMapper;

	@Autowired
	public EssentialOilManagerServiceImpl(EssentialOilDao essentialOilDao,
			EssentialOilDomainService essentialOilDomainService,
			OrikaBeanMapper orikaBeanMapper) {
		super();
		this.essentialOilDao = essentialOilDao;
		this.essentialOilDomainService = essentialOilDomainService;
		this.orikaBeanMapper = orikaBeanMapper;
	}

	@Override
	public EssentialOilDto addEssentialOil(EssentialOilDto essentialOilDto) {
		EssentialOil essentialOil = orikaBeanMapper.map(essentialOilDto, EssentialOil.class);
		return orikaBeanMapper.convertDTO(essentialOilDomainService.addEssentialOil(essentialOil),
				EssentialOilDto.class);
	}

	@Override
	public EssentialOilDto editEssentialOil(EssentialOilDto essentialOilDto, long idEssentialOil) {
		EssentialOil essentialOil = orikaBeanMapper.map(essentialOilDto, EssentialOil.class);
		EssentialOil existEssentialOil = essentialOilDao.getOne(idEssentialOil);
		return orikaBeanMapper.convertDTO(essentialOilDomainService.editEssentialOil(essentialOil, existEssentialOil),
				EssentialOilDto.class);
	}

	@Override
	public EssentialOilDto findEssentialOil(long idEssentialOil) {
		return orikaBeanMapper.convertDTO(essentialOilDao.getOne(idEssentialOil), EssentialOilDto.class);
	}


	@Override
	public void deleteEssentialOil(long idEssentialOil) {
		EssentialOil existEssentialOil = essentialOilDao.getOne(idEssentialOil);
		essentialOilDao.delete(existEssentialOil);
	}

	@Override
	public boolean essentialOilNameExists(String checkedName) {
		return essentialOilDao.existsByName(checkedName);
	}

	@Override
	public List<EssentialOilDto> findEssentialOils() {
		List<EssentialOil> essentialOils = essentialOilDao.findAll();
		essentialOils = essentialOils.stream().sorted(Comparator.comparing(EssentialOil::getName))
				.collect(Collectors.toList());
		return orikaBeanMapper.convertListDTO(essentialOils, EssentialOilDto.class);
	}

}
