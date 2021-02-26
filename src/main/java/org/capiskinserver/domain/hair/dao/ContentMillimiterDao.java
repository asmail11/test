package org.capiskinserver.domain.hair.dao;

import org.capiskinserver.domain.hair.modal.ContentMillimiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentMillimiterDao extends JpaRepository<ContentMillimiter, Long>{

}
