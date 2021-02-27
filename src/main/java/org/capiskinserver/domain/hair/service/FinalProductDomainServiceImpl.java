package org.capiskinserver.domain.hair.service;

import java.util.Date;

import org.capiskinserver.domain.hair.dao.FinalProductDao;
import org.capiskinserver.domain.hair.modal.ContentMillimiter;
import org.capiskinserver.domain.hair.modal.FinalProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FinalProductDomainServiceImpl implements FinalProductDomainService {

	@Autowired
	private FinalProductDao finalProductDao;

	@Override
	public FinalProduct addFinalProduct(FinalProduct finalProduct,
			ContentMillimiter contentMillimiter) {
		if (finalProduct != null && contentMillimiter != null) {
			finalProduct.setCreatedAt(new Date());
			finalProduct.setContentMillimiter(contentMillimiter);
			contentMillimiter.setFinalProduct(finalProduct);
			return finalProductDao.save(finalProduct);
		}
		return null;
	}
}
