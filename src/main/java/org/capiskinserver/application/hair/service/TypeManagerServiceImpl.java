package org.capiskinserver.application.hair.service;


import javax.transaction.Transactional;

import org.capiskinserver.application.hair.dto.TypeDto;
import org.capiskinserver.domain.hair.OrikaBeanMapper;
import org.capiskinserver.domain.hair.dao.BodyFaceHairDao;
import org.capiskinserver.domain.hair.dao.TypeDao;
import org.capiskinserver.domain.hair.modal.BodyFaceHair;
import org.capiskinserver.domain.hair.modal.Type;
import org.capiskinserver.domain.hair.service.TypeDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TypeManagerServiceImpl implements TypeManagerService {

	private OrikaBeanMapper orikaBeanMapper;

	private TypeDao typeDao;

	private TypeDomainService typeDomainService;

	private BodyFaceHairDao bodyFaceHairDao;

	@Autowired
	public TypeManagerServiceImpl(OrikaBeanMapper orikaBeanMapper, TypeDao typeDao, TypeDomainService typeDomainService,
			BodyFaceHairDao bodyFaceHairDao) {
		super();
		this.orikaBeanMapper = orikaBeanMapper;
		this.typeDao = typeDao;
		this.typeDomainService = typeDomainService;
		this.bodyFaceHairDao = bodyFaceHairDao;
	}

	@Override
	public TypeDto addType(TypeDto typeDto, long idBody) {
		Type type = orikaBeanMapper.map(typeDto, Type.class);
		BodyFaceHair bodyFaceHair = bodyFaceHairDao.getOne(idBody);
		return orikaBeanMapper.convertDTO(typeDomainService.addType(type, bodyFaceHair), TypeDto.class);
	}

	@Override
	public TypeDto editType(TypeDto typeDto, long idType) {
		Type type = orikaBeanMapper.map(typeDto, Type.class);
		Type existType = typeDao.getOne(idType);
		return orikaBeanMapper.convertDTO(typeDomainService.ediType(type, existType), TypeDto.class);
	}

	@Override
	public TypeDto findType(long idType) {
		return orikaBeanMapper.convertDTO(typeDao.getOne(idType), TypeDto.class);
	}

	@Override
	public void deleteType(long idType) {
		Type existType = typeDao.getOne(idType);
		typeDao.delete(existType);
	}


	@Override
	public boolean typeNameExists(String checkedName) {
		return typeDao.existsByName(checkedName);
	}

}
