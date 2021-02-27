package org.capiskinserver.application.hair.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.capiskinserver.application.hair.dto.BodyAndHairDto;
import org.capiskinserver.domain.hair.OrikaBeanMapper;
import org.capiskinserver.domain.hair.dao.BodyAndHairDao;
import org.capiskinserver.domain.hair.dao.CategoryDao;
import org.capiskinserver.domain.hair.modal.BodyAndHair;
import org.capiskinserver.domain.hair.modal.Category;
import org.capiskinserver.domain.hair.service.BodyAndHairDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class BodyAndHairManagerServiceImpl implements BodyAndHairManagerService {

	private BodyAndHairDomainService bodyAndHairDomainService;

	private BodyAndHairDao bodyAndHairDao;

	private OrikaBeanMapper orikaBeanMapper;

	private CategoryDao categoryDao;

	@Autowired
	public BodyAndHairManagerServiceImpl(BodyAndHairDomainService bodyAndHairDomainService,
			BodyAndHairDao bodyAndHairDao, OrikaBeanMapper orikaBeanMapper, CategoryDao categoryDao) {
		super();
		this.bodyAndHairDomainService = bodyAndHairDomainService;
		this.bodyAndHairDao = bodyAndHairDao;
		this.orikaBeanMapper = orikaBeanMapper;
		this.categoryDao = categoryDao;
	}

	@Override
	public BodyAndHairDto addAndHair(BodyAndHairDto bodyAndHairDto, long idCategory) {
		BodyAndHair bodyAndHair = orikaBeanMapper.map(bodyAndHairDto, BodyAndHair.class);
		Category category = categoryDao.getOne(idCategory);
		return orikaBeanMapper.convertDTO(bodyAndHairDomainService.addBodyAndHair(bodyAndHair, category),
				BodyAndHairDto.class);
	}

	@Override
	public BodyAndHairDto editAndHair(BodyAndHairDto bodyAndHairDto, long idBodyAndHair) {
		BodyAndHair bodyAndHair = orikaBeanMapper.map(bodyAndHairDto, BodyAndHair.class);
		BodyAndHair existBodyAndHair = bodyAndHairDao.getOne(idBodyAndHair);
		return orikaBeanMapper.convertDTO(bodyAndHairDomainService.editBodyAndHair(bodyAndHair, existBodyAndHair),
				BodyAndHairDto.class);
	}

	@Override
	public BodyAndHairDto findBodyAndHair(long idBodyAndHair) {
		return orikaBeanMapper.convertDTO(bodyAndHairDao.getOne(idBodyAndHair), BodyAndHairDto.class);
	}

	@Override
	public void deleteBodyAndHair(long idBodyAndHair) {
		BodyAndHair existBodyAndHair = bodyAndHairDao.getOne(idBodyAndHair);
		bodyAndHairDao.delete(existBodyAndHair);
	}

	@Override
	public List<BodyAndHairDto> findBodyAndHairForCategory(long idCategory) {
		Category category = categoryDao.getOne(idCategory);
		List<BodyAndHair> bodyAndHairs = category.getBodyAndHairs();
		bodyAndHairs = bodyAndHairs.stream().sorted(Comparator.comparing(BodyAndHair::getName))
				.collect(Collectors.toList());
		return orikaBeanMapper.convertListDTO(bodyAndHairs, BodyAndHairDto.class);
	}

}
