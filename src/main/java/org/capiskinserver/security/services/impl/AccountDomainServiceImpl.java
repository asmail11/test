package org.capiskinserver.security.services.impl;

import org.capiskinserver.security.model.Account;
import org.capiskinserver.security.model.User;
import org.capiskinserver.security.repository.AccountDao;
import org.capiskinserver.security.services.AccountDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountDomainServiceImpl implements AccountDomainService {
	
	@Autowired
	private AccountDao accountDao;

	@Override
	public Account addAccount(Account account, User user) {
		if (account!=null && user!=null) {
			account.setUser(user);
			user.setAccount(account);
			return accountDao.save(account);
		}
		return null;
	}

	@Override
	public Account updateAccount(Account account, Account existAccount) {
		if (account!=null && existAccount!=null) {
			existAccount.setName(account.getName());
			existAccount.setAddress(account.getAddress());
			existAccount.setCity(account.getCity());
			existAccount.setCodePostale(account.getCodePostale());
			existAccount.setConditionAccept(account.getConditionAccept());
			existAccount.setGender(account.getGender());
			existAccount.setPhone(account.getPhone());
			return accountDao.save(existAccount);
		}
		return null;
	}

}
