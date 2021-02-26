package org.capiskinserver.domain.hair.service;

import java.util.Date;

import org.capiskinserver.domain.hair.dao.BaseProductDao;
import org.capiskinserver.domain.hair.modal.BaseProduct;
import org.capiskinserver.domain.hair.modal.Needs;
import org.capiskinserver.exception.AlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaseProductDomainServiceImpl implements BaseProductDomainService {

	@Autowired
	private BaseProductDao baseProductDao;

	@Override
	public BaseProduct addBaseProduct(BaseProduct baseProduct, Needs needs) {
		if (needs.hasBaseProduct(baseProduct.getName())) {
			throw new AlreadyExistsException("\n The name of baseProduct has be unique \n");
		}
		if (baseProduct != null && needs != null) {
			baseProduct.setCreatedAt(new Date());
			needs.addBaseProduct(baseProduct);
			return baseProductDao.save(baseProduct);
		}
		return null;
	}

	@Override
	public BaseProduct editBaseProduct(BaseProduct baseProduct, BaseProduct existBaseProduct) {
		if (baseProduct != null && existBaseProduct != null) {
			existBaseProduct.setCreatedAt(null);
			existBaseProduct.setUpdatedAt(new Date());
			existBaseProduct.setName(baseProduct.getName());
			existBaseProduct.setPrice(baseProduct.getPrice());
			existBaseProduct.setDescription(baseProduct.getDescription());
			return baseProductDao.save(existBaseProduct);
		}
		return null;
	};

}
