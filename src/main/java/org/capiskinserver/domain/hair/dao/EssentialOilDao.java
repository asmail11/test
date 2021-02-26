package org.capiskinserver.domain.hair.dao;

import org.capiskinserver.domain.hair.modal.EssentialOil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EssentialOilDao extends JpaRepository<EssentialOil, Long>{

}
