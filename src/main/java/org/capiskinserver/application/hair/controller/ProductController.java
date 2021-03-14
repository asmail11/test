package org.capiskinserver.application.hair.controller;

import java.util.List;

import org.capiskinserver.application.hair.dto.ProductDto;
import org.capiskinserver.application.hair.service.ProductManagerService;
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
public class ProductController extends RestBaseController {

	@Autowired
	private ProductManagerService productManagerService;

	@PostMapping("/addProduct")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasRole('ADMIN')")
	ProductDto addProduct(@RequestBody ProductDto productDto) {
		return productManagerService.addProduct(productDto);
	}

	@PutMapping("/editProduct/{idProduct}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasRole('ADMIN')")
	ProductDto editProduct(@RequestBody ProductDto productDto, @PathVariable long idProduct) {
		return productManagerService.editProduct(productDto, idProduct);
	}

	@GetMapping("/findProduct/{id}")
	ProductDto findProduct(@PathVariable long id) {
		return productManagerService.findProduct(id);
	}

	@DeleteMapping("/deleteProduct/{id}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasRole('ADMIN')")
	void deleteProduct(@PathVariable long id) {
		productManagerService.deleteProduct(id);
	}

	@GetMapping("/findProducts")
	List<ProductDto> findProducts() {
		return productManagerService.findProducts();
	}

	@GetMapping("/productNameExists/{name}")
	boolean productNameExists(@PathVariable String name) {
		return productManagerService.productNameExists(name);
	}

}
