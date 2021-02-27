package org.capiskinserver.application.hair.service;

import org.capiskinserver.application.hair.dto.ContentMillimiterDto;
import org.capiskinserver.domain.hair.OrikaBeanMapper;
import org.capiskinserver.domain.hair.dao.ContentMillimiterDao;
import org.capiskinserver.domain.hair.dao.FinalProductDao;
import org.capiskinserver.domain.hair.modal.ContentMillimiter;
import org.capiskinserver.domain.hair.modal.FinalProduct;
import org.capiskinserver.domain.hair.service.ContentMillimiterDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class ContentMillimiterManagerServiceImpl implements ContentMillimiterManagerService {
	
	private ContentMillimiterDao contentMillimiterDao;
	
	private ContentMillimiterDomainService contentMillimiterDomainService;
	
	private FinalProductDao finalProductDao;
	
	private OrikaBeanMapper orikaBeanMapper;

	@Autowired
	public ContentMillimiterManagerServiceImpl(ContentMillimiterDao contentMillimiterDao,
			ContentMillimiterDomainService contentMillimiterDomainService, FinalProductDao finalProductDao,
			OrikaBeanMapper orikaBeanMapper) {
		super();
		this.contentMillimiterDao = contentMillimiterDao;
		this.contentMillimiterDomainService = contentMillimiterDomainService;
		this.finalProductDao = finalProductDao;
		this.orikaBeanMapper = orikaBeanMapper;
	}

	@Override
	public ContentMillimiterDto addContentMillimiter(ContentMillimiterDto contentMillimiterDto, long idFinalProduct) {
		ContentMillimiter contentMillimiter = orikaBeanMapper.map(contentMillimiterDto, ContentMillimiter.class);
		FinalProduct finalProduct = finalProductDao.getOne(idFinalProduct);
		return orikaBeanMapper.convertDTO(contentMillimiterDomainService
				.addContentMillimiter(contentMillimiter, finalProduct), ContentMillimiterDto.class);
	}

	@Override
	public ContentMillimiterDto editContentMillimiter(ContentMillimiterDto contentMillimiterDto,
			long idContentMillimiter) {
		ContentMillimiter contentMillimiter = orikaBeanMapper.map(contentMillimiterDto, ContentMillimiter.class);
		ContentMillimiter existContentMillimiter = contentMillimiterDao.getOne(idContentMillimiter);
		return orikaBeanMapper.convertDTO(contentMillimiterDomainService
				.editContentMillimiter(contentMillimiter, existContentMillimiter), ContentMillimiterDto.class);
	}

	@Override
	public ContentMillimiterDto findContentMillimiter(long idContentMillimiter) {
		return orikaBeanMapper.convertDTO(contentMillimiterDao.getOne(idContentMillimiter), ContentMillimiterDto.class);
	}

	@Override
	public void deleteContentMillimiter(long idContentMillimiter, long idFinalProduct) {
		ContentMillimiter existContentMillimiter = contentMillimiterDao.getOne(idContentMillimiter);
		FinalProduct finalProduct = finalProductDao.getOne(idFinalProduct);
		existContentMillimiter.setFinalProduct(null);
		finalProduct.setContentMillimiter(null);
		contentMillimiterDao.delete(existContentMillimiter);
	}

	@Override
	public ContentMillimiterDto findContentMillimiterForProduct(long idFinalProduct) {
		FinalProduct finalProduct = finalProductDao.getOne(idFinalProduct);
		return orikaBeanMapper.convertDTO(finalProduct.getContentMillimiter(), ContentMillimiterDto.class);
	}
	
	

}
