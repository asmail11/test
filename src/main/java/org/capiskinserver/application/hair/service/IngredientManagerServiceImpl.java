package org.capiskinserver.application.hair.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.capiskinserver.application.hair.dto.IngredientDto;
import org.capiskinserver.domain.hair.OrikaBeanMapper;
import org.capiskinserver.domain.hair.dao.FaceAndCareDao;
import org.capiskinserver.domain.hair.dao.IngredientDao;
import org.capiskinserver.domain.hair.modal.FaceAndCare;
import org.capiskinserver.domain.hair.modal.Ingredient;
import org.capiskinserver.domain.hair.service.IngredientDomainService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class IngredientManagerServiceImpl implements IngredientManagerService {

	private IngredientDomainService ingrdientDomainService;

	private IngredientDao ingrdientDao;

	private FaceAndCareDao faceAndCareDao;

	private OrikaBeanMapper orikaBeanMapper;

	public IngredientManagerServiceImpl(IngredientDomainService ingrdientDomainService, IngredientDao ingrdientDao,
			FaceAndCareDao faceAndCareDao, OrikaBeanMapper orikaBeanMapper) {
		super();
		this.ingrdientDomainService = ingrdientDomainService;
		this.ingrdientDao = ingrdientDao;
		this.faceAndCareDao = faceAndCareDao;
		this.orikaBeanMapper = orikaBeanMapper;
	}

	@Override
	public IngredientDto addIngrdient(IngredientDto ingrdientDto, long idFace) {
		Ingredient ingrdient = orikaBeanMapper.map(ingrdientDto, Ingredient.class);
		FaceAndCare faceAndCare = faceAndCareDao.getOne(idFace);
		return orikaBeanMapper.convertDTO(ingrdientDomainService.addIngredient(ingrdient, faceAndCare),
				IngredientDto.class);
	}

	@Override
	public IngredientDto editIngrdient(IngredientDto ingrdientDto, long idIngrdient) {
		Ingredient ingrdient = orikaBeanMapper.map(ingrdientDto, Ingredient.class);
		Ingredient existIngrdient = ingrdientDao.getOne(idIngrdient);
		return orikaBeanMapper.convertDTO(ingrdientDomainService.editIngredient(ingrdient, existIngrdient),
				IngredientDto.class);
	}

	@Override
	public IngredientDto findIngrdient(long idIngrdient) {
		return orikaBeanMapper.convertDTO(ingrdientDao.getOne(idIngrdient), IngredientDto.class);
	}

	@Override
	public void deleteIngrdient(long idIngrdient) {
		Ingredient existIngrdient = ingrdientDao.getOne(idIngrdient);
		ingrdientDao.delete(existIngrdient);
	}

	@Override
	public List<IngredientDto> findIngrdientsForFaceAndCare(long idFace) {
		FaceAndCare faceAndCare = faceAndCareDao.getOne(idFace);
		List<Ingredient> ingrdients = faceAndCare.getIngredients();
		ingrdients = ingrdients.stream().sorted(Comparator.comparing(Ingredient::getName)).collect(Collectors.toList());
		return orikaBeanMapper.convertListDTO(ingrdients, IngredientDto.class);
	}

}
