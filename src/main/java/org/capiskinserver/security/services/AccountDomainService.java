package org.capiskinserver.security.services;

import org.capiskinserver.security.model.Account;
import org.capiskinserver.security.model.User;
import org.springframework.stereotype.Service;

@Service
public interface AccountDomainService {
	
	Account addAccount(Account account, User user);
	
	
	Account updateAccount(Account account, Account existAccount);

}
