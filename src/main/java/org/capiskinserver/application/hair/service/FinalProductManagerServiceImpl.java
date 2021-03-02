package org.capiskinserver.application.hair.service;

import java.util.List;

import org.capiskinserver.application.hair.dto.FinalProductDto;
import org.capiskinserver.domain.hair.OrikaBeanMapper;
import org.capiskinserver.domain.hair.dao.ContentMillimiterDao;
import org.capiskinserver.domain.hair.dao.FinalProductDao;
import org.capiskinserver.domain.hair.dao.IngredientProductDao;
import org.capiskinserver.domain.hair.modal.ContentMillimiter;
import org.capiskinserver.domain.hair.modal.FinalProduct;
import org.capiskinserver.domain.hair.modal.IngredientProduct;
import org.capiskinserver.domain.hair.service.FinalProductDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FinalProductManagerServiceImpl implements FinalProductManagerService {

	private FinalProductDao finalProductDao;

	private FinalProductDomainService finalProductDomainService;

	private IngredientProductDao ingredientProductDao;

	private ContentMillimiterDao contentMillimiterDao;

	private OrikaBeanMapper orikaBeanMapper;

	@Autowired
	public FinalProductManagerServiceImpl(FinalProductDao finalProductDao,
			FinalProductDomainService finalProductDomainService, IngredientProductDao ingredientProductDao,
			ContentMillimiterDao contentMillimiterDao, OrikaBeanMapper orikaBeanMapper) {
		super();
		this.finalProductDao = finalProductDao;
		this.finalProductDomainService = finalProductDomainService;
		this.ingredientProductDao = ingredientProductDao;
		this.contentMillimiterDao = contentMillimiterDao;
		this.orikaBeanMapper = orikaBeanMapper;
	}

	@Override
	public FinalProductDto addFinalProduct(FinalProductDto finalProductDto, List<Long> idIngredients, long idContent) {
		FinalProduct finalProduct = orikaBeanMapper.map(finalProductDao, FinalProduct.class);
		assert idIngredients != null;
		finalProduct.getIngredientProducts().clear();

		for (long idIngredient : idIngredients) {
			IngredientProduct ingredientProduct = ingredientProductDao.getOne(idIngredient);
			finalProduct.addIngredientProductForProduct(ingredientProduct);
		}

		ContentMillimiter contentMillimiter = contentMillimiterDao.getOne(idContent);
		return orikaBeanMapper.convertDTO(finalProductDomainService.addFinalProduct(finalProduct, contentMillimiter),
				FinalProductDto.class);
	}

	@Override
	public void deleteFinalProduct(long idFinalProduct, long idIngredient, long idContent) {
		FinalProduct finalProduct = finalProductDao.getOne(idFinalProduct);
		IngredientProduct ingredientProduct = ingredientProductDao.getOne(idIngredient);
		ContentMillimiter contentMillimiter = contentMillimiterDao.getOne(idContent);
		finalProduct.setContentMillimiter(null);
		ingredientProduct.getFinalProducts().remove(finalProduct);
		finalProduct.getIngredientProducts().remove(ingredientProduct);
		contentMillimiter.setFinalProduct(null);
		finalProductDao.delete(finalProduct);
	}

}
