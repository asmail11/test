package org.capiskinserver.application.hair.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.capiskinserver.application.hair.dto.BodyFaceHairDto;
import org.capiskinserver.domain.hair.OrikaBeanMapper;
import org.capiskinserver.domain.hair.dao.BodyFaceHairDao;
import org.capiskinserver.domain.hair.modal.BodyFaceHair;
import org.capiskinserver.domain.hair.service.BodyFaceHairDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BodyFaceHairManagerServiceImpl implements BodyFaceHairManagerService {

	private BodyFaceHairDomainService bodyAndHairDomainService;

	private BodyFaceHairDao bodyAndHairDao;

	private OrikaBeanMapper orikaBeanMapper;

	@Autowired
	public BodyFaceHairManagerServiceImpl(BodyFaceHairDomainService bodyAndHairDomainService,
			BodyFaceHairDao bodyAndHairDao, OrikaBeanMapper orikaBeanMapper) {
		super();
		this.bodyAndHairDomainService = bodyAndHairDomainService;
		this.bodyAndHairDao = bodyAndHairDao;
		this.orikaBeanMapper = orikaBeanMapper;
	}

	@Override
	public BodyFaceHairDto addBodyFaceHair(BodyFaceHairDto bodyAndHairDto) {
		BodyFaceHair bodyAndHair = orikaBeanMapper.map(bodyAndHairDto, BodyFaceHair.class);
		return orikaBeanMapper.convertDTO(bodyAndHairDomainService.addBodyFaceHair(bodyAndHair),
				BodyFaceHairDto.class);
	}

	@Override
	public BodyFaceHairDto editBodyFaceHair(BodyFaceHairDto bodyAndHairDto, long idBodyAndHair) {
		BodyFaceHair bodyAndHair = orikaBeanMapper.map(bodyAndHairDto, BodyFaceHair.class);
		BodyFaceHair existBodyAndHair = bodyAndHairDao.getOne(idBodyAndHair);
		return orikaBeanMapper.convertDTO(bodyAndHairDomainService.editBodyFaceHair(bodyAndHair, existBodyAndHair),
				BodyFaceHairDto.class);
	}

	@Override
	public BodyFaceHairDto findBodyFaceHair(long idBodyAndHair) {
		return orikaBeanMapper.convertDTO(bodyAndHairDao.getOne(idBodyAndHair), BodyFaceHairDto.class);
	}

	@Override
	public void deleteBodyFaceHair(long idBodyAndHair) {
		BodyFaceHair existBodyAndHair = bodyAndHairDao.getOne(idBodyAndHair);
		bodyAndHairDao.delete(existBodyAndHair);
	}

	@Override
	public List<BodyFaceHairDto> findBodyFaceHairs() {
		List<BodyFaceHair> bodyAndHairs = bodyAndHairDao.findAll();
		bodyAndHairs = bodyAndHairs.stream().sorted(Comparator.comparing(BodyFaceHair::getName))
				.collect(Collectors.toList());
		return orikaBeanMapper.convertListDTO(bodyAndHairs, BodyFaceHairDto.class);
	}

	@Override
	public boolean bodyAndHairNameExists(String checkedName) {
		return bodyAndHairDao.existsByName(checkedName);
	}

}
