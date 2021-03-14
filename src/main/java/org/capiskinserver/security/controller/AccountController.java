package org.capiskinserver.security.controller;

import org.capiskinserver.security.model.AccountDto;
import org.capiskinserver.security.services.AccountManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class AccountController {
	
	@Autowired
	private AccountManagerService accountManagerService;
	
	@PostMapping("/addAccount/{idUser}")
	AccountDto addAccount(@RequestBody AccountDto accountDto, @PathVariable long idUser) {
		return accountManagerService.addAccount(accountDto, idUser);
	}
	@GetMapping("/findAccountForUser/{idUser}")
	AccountDto findAccountForUser(@PathVariable long idUser) {
		return accountManagerService.findAccountForUser(idUser);
	}
	@PutMapping("/updateAccount/{idAccount}")
	AccountDto updateAccount(@RequestBody AccountDto accountDto, @PathVariable long idAccount) {
		return accountManagerService.updateAccount(accountDto, idAccount);
	}
	@DeleteMapping("/deleteAccount/{idUser}/{idAccount}")
	void deleteAccount(@PathVariable long idUser, @PathVariable long idAccount) {
		accountManagerService.deleteAccount(idUser, idAccount);
	}
}
