package org.capiskinserver.domain.hair.dao;

import org.capiskinserver.domain.hair.modal.VegetableOil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VegetableOilDao extends JpaRepository<VegetableOil, Long> {

}
