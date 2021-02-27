package org.capiskinserver.application.hair.controller;

import org.capiskinserver.application.hair.dto.ActifDto;
import org.capiskinserver.application.hair.service.ActifManagerService;
import org.capiskinserver.config.RestBaseController;
import org.springframework.beans.factory.annotation.Autowired;
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

	@PostMapping("/addActif/{idCharacteristic}")
	ActifDto addActif(@RequestBody ActifDto actifDto, @PathVariable long idCharacteristic) {
		return actifManagerService.addActif(actifDto, idCharacteristic);
	}

	@PutMapping("/editActif/{idActif}")
	ActifDto editActif(@RequestBody ActifDto actifDto, @PathVariable long idActif) {
		return actifManagerService.editActif(actifDto, idActif);
	}

	@GetMapping("/findActif/{idActif}")
	ActifDto findActif(@PathVariable long idActif) {
		return actifManagerService.findActif(idActif);
	}

	@GetMapping("/findActifForCharacteristic/{idCharacteristic}")
	ActifDto findActifForCharacteristic(@PathVariable long idCharacteristic) {
		return actifManagerService.findActifForCharacteristic(idCharacteristic);
	}

	@DeleteMapping("/deleteActif/{idActif}/{idCharacteristic}")
	void deleteActif(@PathVariable long idActif, @PathVariable long idCharacteristic) {
		actifManagerService.deleteActif(idActif, idCharacteristic);
	}

}
