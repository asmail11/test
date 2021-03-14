package org.capiskinserver.application.hair.controller;

import java.util.List;

import org.capiskinserver.application.hair.dto.BodyFaceHairDto;
import org.capiskinserver.application.hair.service.BodyFaceHairManagerService;
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
public class BodyFaceHairController extends RestBaseController {

	@Autowired
	private BodyFaceHairManagerService bodyAndHairManagerService;

	@PostMapping("/addBodyFaceHair")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasRole('ADMIN')")
	BodyFaceHairDto addBodyFaceHair(@RequestBody BodyFaceHairDto bodyAndHairDto) {
		return bodyAndHairManagerService.addBodyFaceHair(bodyAndHairDto);
	}

	@PutMapping("/editBodyFaceHair/{idBodyAndHair}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasRole('ADMIN')")
	BodyFaceHairDto editBodyFaceHair(@RequestBody BodyFaceHairDto bodyAndHairDto, @PathVariable long idBodyAndHair) {
		return bodyAndHairManagerService.editBodyFaceHair(bodyAndHairDto, idBodyAndHair);
	}

	@GetMapping("/findBodyFaceHair/{idBodyAndHair}")
	BodyFaceHairDto findBodyFaceHair(@PathVariable long idBodyAndHair) {
		return bodyAndHairManagerService.findBodyFaceHair(idBodyAndHair);
	}

	@DeleteMapping("/deleteBodyFaceHair/{idBodyAndHair}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasRole('ADMIN')")
	void deleteBodyFaceHair(@PathVariable long idBodyAndHair) {
		bodyAndHairManagerService.deleteBodyFaceHair(idBodyAndHair);
	}

	@GetMapping("/findBodyFaceHairs")
	List<BodyFaceHairDto> findBodyFaceHairs() {
		return bodyAndHairManagerService.findBodyFaceHairs();
	}

	@GetMapping("/bodyAndHairNameExists/checkedName/{checkedName}")
	boolean bodyAndHairNameExists(@PathVariable String checkedName) {
		return bodyAndHairManagerService.bodyAndHairNameExists(checkedName);
	}

}
