package org.capiskinserver.domain.hair.service;

import java.util.Date;

import org.capiskinserver.domain.hair.dao.ContentMillimiterDao;
import org.capiskinserver.domain.hair.modal.ContentMillimiter;
import org.capiskinserver.domain.hair.modal.FinalProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContentMillimiterDomainServiceImpl implements ContentMillimiterDomainService {

	@Autowired
	private ContentMillimiterDao contentMillimiterDao;

	@Override
	public ContentMillimiter addContentMillimiter(ContentMillimiter contentMillimiter, FinalProduct finalProduct) {
		if (contentMillimiter != null && finalProduct != null) {
			contentMillimiter.setCreatedAt(new Date());
			contentMillimiter.setFinalProduct(finalProduct);
			finalProduct.setContentMillimiter(contentMillimiter);
			return contentMillimiterDao.save(contentMillimiter);
		}
		return null;
	}

	@Override
	public ContentMillimiter editContentMillimiter(ContentMillimiter contentMillimiter,
			ContentMillimiter existContentMillimiter) {
		if (contentMillimiter != null && existContentMillimiter != contentMillimiter) {
			existContentMillimiter.setCreatedAt(null);
			existContentMillimiter.setUpdatedAt(new Date());
			existContentMillimiter.setSmallMillimiter(contentMillimiter.getSmallMillimiter());
			existContentMillimiter.setMeduimMillimiter(contentMillimiter.getMeduimMillimiter());
			existContentMillimiter.setBigMillimiter(contentMillimiter.getBigMillimiter());
			existContentMillimiter.setSmallPrice(contentMillimiter.getSmallPrice());
			existContentMillimiter.setMeduimPrice(contentMillimiter.getMeduimPrice());
			existContentMillimiter.setBigPrice(contentMillimiter.getBigPrice());
			return contentMillimiterDao.save(existContentMillimiter);
		}
		return null;
	}

}
