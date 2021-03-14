package org.capiskinserver.security.services.impl;

import javax.transaction.Transactional;

import org.capiskinserver.domain.hair.OrikaBeanMapper;
import org.capiskinserver.security.model.Account;
import org.capiskinserver.security.model.AccountDto;
import org.capiskinserver.security.model.User;
import org.capiskinserver.security.repository.AccountDao;
import org.capiskinserver.security.repository.UserRepository;
import org.capiskinserver.security.services.AccountDomainService;
import org.capiskinserver.security.services.AccountManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AccountManagerServiceImpl implements AccountManagerService {

	private OrikaBeanMapper orikaBeanMapper;

	private AccountDomainService accountDomainService;

	private UserRepository userRepository;

	private AccountDao accountDao;

	@Autowired
	public AccountManagerServiceImpl(OrikaBeanMapper orikaBeanMapper, AccountDomainService accountDomainService,
			UserRepository userRepository, AccountDao accountDao) {
		super();
		this.orikaBeanMapper = orikaBeanMapper;
		this.accountDomainService = accountDomainService;
		this.userRepository = userRepository;
		this.accountDao = accountDao;
	}

	@Override
	public AccountDto addAccount(AccountDto accountDto, long idUser) {
		Account account = orikaBeanMapper.map(accountDto, Account.class);
		User user = userRepository.getOne(idUser);
		return orikaBeanMapper.convertDTO(accountDomainService.addAccount(account, user), AccountDto.class);
	}

	@Override
	public AccountDto findAccountForUser(long idUser) {
		User user = userRepository.getOne(idUser);
		return orikaBeanMapper.convertDTO(user.getAccount(), AccountDto.class);
	}

	@Override
	public AccountDto updateAccount(AccountDto accountDto, long idAccount) {
		Account account = orikaBeanMapper.map(accountDto, Account.class);
		Account existAccount = accountDao.getOne(idAccount);
		return orikaBeanMapper.convertDTO(accountDomainService.updateAccount(account, existAccount), AccountDto.class);
	}

	@Override
	public void deleteAccount(long idUser, long idAccount) {
		User user = userRepository.getOne(idUser);
		user.setAccount(null);
		Account existAccount = accountDao.getOne(idAccount);
		accountDao.delete(existAccount);
	}

}
