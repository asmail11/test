package org.capiskinserver.domain.hair.dao;

import org.capiskinserver.domain.hair.modal.BodyAndHair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BodyAndHairDao extends JpaRepository<BodyAndHair, Long>{

}
