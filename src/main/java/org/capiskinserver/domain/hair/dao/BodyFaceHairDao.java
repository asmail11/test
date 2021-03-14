package org.capiskinserver.domain.hair.dao;

import org.capiskinserver.domain.hair.modal.BodyFaceHair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BodyFaceHairDao extends JpaRepository<BodyFaceHair, Long>{
    boolean existsByName(String checkedName);
}
