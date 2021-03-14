package org.capiskinserver.application.hair.controller;


import org.capiskinserver.application.hair.dto.TypeDto;
import org.capiskinserver.application.hair.service.TypeManagerService;
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
public class TypeController extends RestBaseController {

	@Autowired
	private TypeManagerService typeManagerService;

	@PostMapping("/addType/{idBody}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasRole('ADMIN')")
	TypeDto addType(@RequestBody TypeDto typeDto, @PathVariable long idBody) {
		return typeManagerService.addType(typeDto, idBody);
	}

	@PutMapping("/editType/{idType}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasRole('ADMIN')")
	TypeDto editType(@RequestBody TypeDto typeDto, @PathVariable long idType) {
		return typeManagerService.editType(typeDto, idType);
	}

	@GetMapping("/findType/{idType}")
	TypeDto findType(@PathVariable long idType) {
		return typeManagerService.findType(idType);
	}

	@DeleteMapping("/deleteType/{idType}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasRole('ADMIN')")
	void deleteType(@PathVariable long idType) {
		typeManagerService.deleteType(idType);
	}

	@GetMapping("/typeNameExists/checkedName/{checkedName}")
	boolean typeNameExists(@PathVariable String checkedName) {
		return typeManagerService.typeNameExists(checkedName);
	}

}
