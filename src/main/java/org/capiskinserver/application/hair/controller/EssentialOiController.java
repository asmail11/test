
package org.capiskinserver.application.hair.controller;

import java.util.List;

import org.capiskinserver.application.hair.dto.EssentialOilDto;
import org.capiskinserver.application.hair.service.EssentialOilManagerService;
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
public class EssentialOiController extends RestBaseController {

	@Autowired
	private EssentialOilManagerService essentialOilManagerService;

	@PostMapping("/addEssentialOil")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasRole('ADMIN')")
	EssentialOilDto addEssentialOil(@RequestBody EssentialOilDto essentialOilDto) {
		return essentialOilManagerService.addEssentialOil(essentialOilDto);
	}

	@PutMapping("/editEssentialOil/{idEssentialOil}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasRole('ADMIN')")
	EssentialOilDto editEssentialOil(@RequestBody EssentialOilDto essentialOilDto, @PathVariable long idEssentialOil) {
		return essentialOilManagerService.editEssentialOil(essentialOilDto, idEssentialOil);
	}

	@GetMapping("/findEssentialOil/{idEssentialOil}")
	EssentialOilDto findEssentialOil(@PathVariable long idEssentialOil) {
		return essentialOilManagerService.findEssentialOil(idEssentialOil);
	}

	@DeleteMapping("/deleteEssentialOil/{idEssentialOil}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasRole('ADMIN')")
	void deleteEssentialOil(@PathVariable long idEssentialOil) {
		essentialOilManagerService.deleteEssentialOil(idEssentialOil);
	}

	@GetMapping("/essentialOilNameExists/checkedName/{checkedName}")
	boolean essentialOilNameExists(@PathVariable String checkedName) {
		return essentialOilManagerService.essentialOilNameExists(checkedName);
	}
	
	@GetMapping("/findEssentialOils")
	List<EssentialOilDto> findEssentialOils() {
		return essentialOilManagerService.findEssentialOils();
	}

}
