package org.capiskinserver.security.services;

import org.capiskinserver.security.model.AccountDto;
import org.springframework.stereotype.Service;

@Service
public interface AccountManagerService {
	
	AccountDto addAccount(AccountDto accountDto, long idUser);
	
	AccountDto updateAccount(AccountDto accountDto, long idAccount);
	
	AccountDto findAccountForUser(long idUser);
	
	void deleteAccount(long idUser, long idAccount);

}
