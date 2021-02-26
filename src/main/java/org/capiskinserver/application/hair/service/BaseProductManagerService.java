package org.capiskinserver.application.hair.service;

import java.util.List;

import org.capiskinserver.application.hair.dto.BaseProductDto;
import org.springframework.stereotype.Service;

@Service
public interface BaseProductManagerService {

	BaseProductDto addBaseProduct(BaseProductDto baseProductDto, long idNeeds);
	
	BaseProductDto editBaseProduct(BaseProductDto baseProductDto, long idBaseProduct);
	
	BaseProductDto findBaseProduct(long idBaseProduct);
	
	List<BaseProductDto> finBaseProductForNeeds(long idNeeds);
	
	void deleteBaseProduct(long idBaseProduct);
}
