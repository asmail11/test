package org.capiskinserver.domain.hair.dao;

import org.capiskinserver.domain.hair.modal.FaceAndCare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaceAndCareDao extends JpaRepository<FaceAndCare, Long> {

}
