package org.capiskinserver.security.repository;

import org.capiskinserver.security.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDao extends JpaRepository<Account, Long> {
	
	

}
