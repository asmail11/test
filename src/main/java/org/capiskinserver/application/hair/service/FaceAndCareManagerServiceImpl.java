package org.capiskinserver.application.hair.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.capiskinserver.application.hair.dto.FaceAndCareDto;
import org.capiskinserver.domain.hair.OrikaBeanMapper;
import org.capiskinserver.domain.hair.dao.BodyAndHairDao;
import org.capiskinserver.domain.hair.dao.FaceAndCareDao;
import org.capiskinserver.domain.hair.modal.BodyAndHair;
import org.capiskinserver.domain.hair.modal.FaceAndCare;
import org.capiskinserver.domain.hair.service.FaceAndCareDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FaceAndCareManagerServiceImpl implements FaceAndCareManagerService {

	private FaceAndCareDao faceAndCareDao;

	private FaceAndCareDomainService faceAndCareDomainService;

	private BodyAndHairDao bodyAndHairDao;

	private OrikaBeanMapper orikaBeanMapper;

	@Autowired
	public FaceAndCareManagerServiceImpl(FaceAndCareDao faceAndCareDao,
			FaceAndCareDomainService faceAndCareDomainService, BodyAndHairDao bodyAndHairDao,
			OrikaBeanMapper orikaBeanMapper) {
		super();
		this.faceAndCareDao = faceAndCareDao;
		this.faceAndCareDomainService = faceAndCareDomainService;
		this.bodyAndHairDao = bodyAndHairDao;
		this.orikaBeanMapper = orikaBeanMapper;
	}

	@Override
	public FaceAndCareDto addFaceAndCare(FaceAndCareDto faceAndCareDto, long idBody) {
		FaceAndCare faceAndCare = orikaBeanMapper.map(faceAndCareDto, FaceAndCare.class);
		BodyAndHair bodyAndHair = bodyAndHairDao.getOne(idBody);
		return orikaBeanMapper.convertDTO(faceAndCareDomainService.addFaceAndCare(faceAndCare, bodyAndHair),
				FaceAndCareDto.class);
	}

	@Override
	public FaceAndCareDto editFaceAndCare(FaceAndCareDto faceAndCareDto, long idFaceAndCare) {
		FaceAndCare faceAndCare = orikaBeanMapper.map(faceAndCareDto, FaceAndCare.class);
		FaceAndCare existFaceAndCare = faceAndCareDao.getOne(idFaceAndCare);
		return orikaBeanMapper.convertDTO(faceAndCareDomainService.editFaceAndCare(faceAndCare, existFaceAndCare),
				FaceAndCareDto.class);
	}

	@Override
	public FaceAndCareDto findFaceAndCare(long idFaceAndCare) {
		return orikaBeanMapper.convertDTO(faceAndCareDao.getOne(idFaceAndCare), FaceAndCareDto.class);
	}

	@Override
	public void deleteFaceAndCare(long idFaceAndCare) {
		FaceAndCare existFaceAndCare = faceAndCareDao.getOne(idFaceAndCare);
		faceAndCareDao.delete(existFaceAndCare);
	}

	@Override
	public List<FaceAndCareDto> findFaceAndCareForBodyAndHair(long idBody) {
		BodyAndHair bodyAndHair = bodyAndHairDao.getOne(idBody);
		List<FaceAndCare> faceAndCares = bodyAndHair.getFaceAndCares();
		faceAndCares = faceAndCares.stream().sorted(Comparator.comparing(FaceAndCare::getName))
				.collect(Collectors.toList());
		return orikaBeanMapper.convertListDTO(faceAndCares, FaceAndCareDto.class);
	}

}
