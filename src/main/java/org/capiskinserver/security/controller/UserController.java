
package org.capiskinserver.security.controller;

import java.util.List;
import org.capiskinserver.security.model.UserDto;

import org.capiskinserver.security.services.UserManagerService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserManagerService userManagerService;

	@GetMapping("/getUserByUsername/{username}")
	UserDto getUserByUsername(@PathVariable String username) {
		return userManagerService.getUserByUsername(username);
	}

	@PutMapping("/updateUser/{idUser}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasRole('ADMIN') or hasAuthority('ROLE_USER') or hasRole('USER')")
	UserDto updateUser(@RequestBody UserDto userDto, @PathVariable long idUser) {
		return userManagerService.updateUser(userDto, idUser);
	}

	@DeleteMapping("/deleteUser/{idUser}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasRole('ADMIN') or hasAuthority('ROLE_USER') or hasRole('USER')")
	void deleteUser(@PathVariable long idUser) {
		userManagerService.deleteUser(idUser);
	}

	@GetMapping("/getUserById/{idUser}")
	UserDto getUserById(@PathVariable long idUser) {
		return userManagerService.getUserById(idUser);
	}

	@GetMapping("/existsByUsername/{username}")
	Boolean existsByUsername(@PathVariable String username) {
		return userManagerService.existsByUsername(username);
	}

	@GetMapping("/findUsers")
	List<UserDto> findUsers() {
		return userManagerService.findUsers();
	}

}
