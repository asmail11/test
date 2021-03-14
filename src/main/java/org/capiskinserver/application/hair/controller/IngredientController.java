package org.capiskinserver.application.hair.controller;

import java.util.List;

import org.capiskinserver.application.hair.dto.IngredientDto;
import org.capiskinserver.application.hair.service.IngredientManagerService;
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
public class IngredientController extends RestBaseController {

	@Autowired
	private IngredientManagerService productManagerService;

	@PostMapping("/addIngredient")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasRole('ADMIN')")
	IngredientDto addProduct(@RequestBody IngredientDto productDto) {
		return productManagerService.addProduct(productDto);
	}

	@PutMapping("/editIngredient/{idProduct}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasRole('ADMIN')")
	IngredientDto editProduct(@RequestBody IngredientDto productDto, @PathVariable long idProduct) {
		return productManagerService.editProduct(productDto, idProduct);
	}

	@GetMapping("/findIngredient/{id}")
	IngredientDto findProduct(@PathVariable long id) {
		return productManagerService.findProduct(id);
	}

	@DeleteMapping("/deleteIngredient/{id}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasRole('ADMIN')")
	void deleteProduct(@PathVariable long id) {
		productManagerService.deleteProduct(id);
	}

	@GetMapping("/findIngredients")
	List<IngredientDto> findProducts() {
		return productManagerService.findProducts();
	}

	@GetMapping("/ingredientNameExists/{name}")
	boolean productNameExists(@PathVariable String name) {
		return productManagerService.productNameExists(name);
	}

}
