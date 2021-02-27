package org.capiskinserver.application.hair.controller;

import java.util.List;

import org.capiskinserver.application.hair.dto.NeedsDto;
import org.capiskinserver.application.hair.service.NeedsManagerService;
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
public class NeedsController extends RestBaseController {

	@Autowired
	private NeedsManagerService needsManagerService;

	@PostMapping("/addNeeds/{idCharacteristic}")
	NeedsDto addNeeds(@RequestBody NeedsDto needsDto, @PathVariable long idCharacteristic) {
		return needsManagerService.addNeeds(needsDto, idCharacteristic);
	}

	@PutMapping("/editNeeds/{idNeeds}")
	NeedsDto editNeeds(@RequestBody NeedsDto needsDto, @PathVariable long idNeeds) {
		return needsManagerService.editNeeds(needsDto, idNeeds);
	}

	@GetMapping("/findNeeds/{idNeeds}")
	NeedsDto findNeeds(@PathVariable long idNeeds) {
		return needsManagerService.findNeeds(idNeeds);
	}

	@DeleteMapping("/deleteNeeds/{idNeeds}")
	void deleteNeeds(@PathVariable long idNeeds) {
		needsManagerService.deleteNeeds(idNeeds);
	}

	@GetMapping("/fiNeedsForCharacteristic/{idCharacteristic}")
	List<NeedsDto> fiNeedsForCharacteristic(@PathVariable long idCharacteristic) {
		return needsManagerService.fiNeedsForCharacteristic(idCharacteristic);
	}

}
