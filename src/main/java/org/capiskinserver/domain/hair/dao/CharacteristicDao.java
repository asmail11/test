package org.capiskinserver.domain.hair.dao;

import org.capiskinserver.domain.hair.modal.Characteristic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacteristicDao extends JpaRepository<Characteristic, Long>{

}
