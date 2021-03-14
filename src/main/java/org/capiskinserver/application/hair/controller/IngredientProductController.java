
package org.capiskinserver.application.hair.controller;

import org.capiskinserver.application.hair.dto.IngredientProductDto;
import org.capiskinserver.application.hair.service.IngredientProductManagerService;
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
public class IngredientProductController extends RestBaseController {

	@Autowired
	private IngredientProductManagerService ingredientProductManagerService;

	@PostMapping("/addIngredientProduct/{idBase}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasRole('ADMIN')")
	IngredientProductDto addIngredientProduct(@RequestBody IngredientProductDto ingredientProductDto,

			@PathVariable long idBase) {
		return ingredientProductManagerService.addIngredientProduct(ingredientProductDto, idBase);
	}

	@PutMapping("/editIngredientProduct/{idIngredientProduct}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasRole('ADMIN')")
	IngredientProductDto editIngredientProduct(@RequestBody IngredientProductDto ingredientProductDto,

			@PathVariable long idIngredientProduct) {
		return ingredientProductManagerService.editIngredientProduct(ingredientProductDto, idIngredientProduct);
	}

	@GetMapping("/findIngredientProduct/{idIngredientProduct}")
	IngredientProductDto findIngredientProduct(@PathVariable long idIngredientProduct) {
		return ingredientProductManagerService.findIngredientProduct(idIngredientProduct);
	}

	@DeleteMapping("/deleteIngredientProduct/{idIngredientProduct}/{idBase}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasRole('ADMIN')")
	void deleteIngredientProduct(@PathVariable long idIngredientProduct, @PathVariable long idBase) {
		ingredientProductManagerService.deleteIngredientProduct(idIngredientProduct, idBase);
	}

	@GetMapping("/findIngredientProductForBaseProduct/{idBase}")
	IngredientProductDto findIngredientProductForBaseProduct(@PathVariable long idBase) {
		return ingredientProductManagerService.findIngredientProductForBaseProduct(idBase);
	}

	@GetMapping("/ingredientProductNameExists/checkedName/{checkedName}")
	boolean ingredientProductNameExists(@PathVariable String checkedName) {
		return ingredientProductManagerService.ingredientProductNameExists(checkedName);
	}

}
