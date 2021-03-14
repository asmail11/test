package org.capiskinserver.application.hair.controller;

import java.util.List;

import org.capiskinserver.application.hair.dto.ActifDto;
import org.capiskinserver.application.hair.service.ActifManagerService;
import org.capiskinserver.util.RestBaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ActifController extends RestBaseController {

	@Autowired
	private ActifManagerService actifManagerService;

	@PostMapping("/addActif")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasRole('ADMIN')")
	ActifDto addActif(@RequestBody ActifDto actifDto) {
		return actifManagerService.addActif(actifDto);
	}

	@PutMapping("/editActif/{idActif}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasRole('ADMIN')")
	ActifDto editActif(@RequestBody ActifDto actifDto, @PathVariable long idActif) {
		return actifManagerService.editActif(actifDto, idActif);
	}

	@GetMapping("/findActif/{idActif}")
	ActifDto findActif(@PathVariable long idActif) {
		return actifManagerService.findActif(idActif);
	}

	@DeleteMapping("/deleteActif/{idActif}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasRole('ADMIN')")
	void deleteActif(@PathVariable long idActif) {
		actifManagerService.deleteActif(idActif);
	}

	@GetMapping("/actifNameExists/checkedName/{checkedName}")
	Boolean actifNameExists(@PathVariable String checkedName) {
		return actifManagerService.actifNameExists(checkedName);
	}
	@GetMapping("/finActifs")
	List<ActifDto> finActifs() {
		return actifManagerService.finActifs();
	}

}
