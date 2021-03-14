
package org.capiskinserver.application.hair.controller;

import java.util.List;

import org.capiskinserver.application.hair.dto.ActifDto;
import org.capiskinserver.application.hair.dto.CharacteristicDto;
import org.capiskinserver.application.hair.dto.EssentialOilDto;
import org.capiskinserver.application.hair.dto.IngredientDto;
import org.capiskinserver.application.hair.service.CharacteristicManagerService;
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
public class CharacteristicController extends RestBaseController {

	@Autowired
	private CharacteristicManagerService characteristicManagerService;

	@PostMapping("/addCharacteristic/{idType}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasRole('ADMIN')")
	CharacteristicDto addCharacteristic(@RequestBody CharacteristicDto characteristicDto, @PathVariable long idType) {
		return characteristicManagerService.addCharacteristic(characteristicDto, idType);
	}

	@PutMapping("/editCharacteristic/{idCharacteristic}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasRole('ADMIN')")
	CharacteristicDto editCharacteristic(@RequestBody CharacteristicDto characteristicDto,
			@PathVariable long idCharacteristic) {
		return characteristicManagerService.editCharacteristic(characteristicDto, idCharacteristic);
	}

	@GetMapping("/findCharacteristic/{idCharacteristic}")
	CharacteristicDto findCharacteristic(@PathVariable long idCharacteristic) {
		return characteristicManagerService.findCharacteristic(idCharacteristic);
	}

	@DeleteMapping("/deleteCharacteristic/{idCharacteristic}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasRole('ADMIN')")
	void deleteCharacteristic(@PathVariable long idCharacteristic) {
		characteristicManagerService.deleteCharacteristic(idCharacteristic);
	}

	@GetMapping("/finCharacteristicForCategory/{idCategory}")
	List<CharacteristicDto> finCharacteristicForCategory(@PathVariable long idCategory) {
		return characteristicManagerService.finCharacteristicForCategory(idCategory);
	}
	@GetMapping("/characteristicNameExists/{name}")
	boolean characteristicNameExists(@PathVariable String name) {
		return characteristicManagerService.characteristicNameExists(name);
	}
	@PostMapping("/addActifToCharacteristic/{idCharacteristic}/{idActif}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasRole('ADMIN')")
	void addActifToCharacteristic(@PathVariable long idCharacteristic, @PathVariable long idActif) {
		characteristicManagerService.addActifToCharacteristic(idCharacteristic, idActif);
	}
	@PostMapping("/addEssentialToCharacteristic/{idCharacteristic}/{idEssential}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasRole('ADMIN')")
	void addEssentialToCharacteristic(@PathVariable long idCharacteristic, @PathVariable long idEssential) {
		characteristicManagerService.addEssentialToCharacteristic(idCharacteristic, idEssential);
	}
	@PostMapping("/addProductToCharacteristic/{idCharacteristic}/{idProduct}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasRole('ADMIN')")
	void addProductToCharacteristic(@PathVariable long idCharacteristic, @PathVariable long idProduct) {
		characteristicManagerService.addProductToCharacteristic(idCharacteristic, idProduct);
	}
	@GetMapping("/findActifsForCharacteristic/{idCharacteristic}")
	List<ActifDto> findActifsForCharacteristic(@PathVariable long idCharacteristic) {
		return characteristicManagerService.findActifsForCharacteristic(idCharacteristic);
	}
	@GetMapping("/findEssentialOilsForCharacteristic/{idCharacteristic}")
	List<EssentialOilDto> findEssentialOilsForCharacteristic(@PathVariable long idCharacteristic) {
		return characteristicManagerService.findEssentialOilsForCharacteristic(idCharacteristic);
	}
	@GetMapping("/findProductsForCharacteristic/{idCharacteristic}")
	List<IngredientDto> findProductsForCharacteristic(@PathVariable long idCharacteristic) {
		return characteristicManagerService.findProductsForCharacteristic(idCharacteristic);
	}
	@DeleteMapping("/removeActifFromCharacteristic/{idCharacteristic}/{idActif}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasRole('ADMIN')")
	void removeActifFromCharacteristic(@PathVariable long idCharacteristic, @PathVariable long idActif) {
		characteristicManagerService.removeActifFromCharacteristic(idCharacteristic, idActif);
	}
	@DeleteMapping("/removeEssentialFromCharacteristic/{idCharacteristic}/{idEssential}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasRole('ADMIN')")
	void removeEssentialFromCharacteristic(@PathVariable long idCharacteristic, @PathVariable long idEssential) {
		characteristicManagerService.removeEssentialFromCharacteristic(idCharacteristic, idEssential);
	}
	@DeleteMapping("/removeProductFromCharacteristic/{idCharacteristic}/{idProduct}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasRole('ADMIN')")
	void removeProductFromCharacteristic(@PathVariable long idCharacteristic, @PathVariable long idProduct) {
		characteristicManagerService.removeProductFromCharacteristic(idCharacteristic, idProduct);
	}
}
