package org.capiskinserver.domain.hair.dao;

import org.capiskinserver.domain.hair.modal.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeDao extends JpaRepository<Type, Long> {

	boolean existsByName(String checkedName);

}
