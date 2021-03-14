package org.capiskinserver.application.hair.controller;

import java.util.List;

import org.capiskinserver.application.hair.dto.BaseProductDto;
import org.capiskinserver.application.hair.service.BaseProductManagerService;
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
public class BaseProductController extends RestBaseController {

	@Autowired
	private BaseProductManagerService baseProductManagerService;

	@PostMapping("/addBaseProduct/{idNeeds}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasRole('ADMIN')")
	BaseProductDto addBaseProduct(@RequestBody BaseProductDto baseProductDto, @PathVariable long idNeeds) {
		return baseProductManagerService.addBaseProduct(baseProductDto, idNeeds);
	}

	@PutMapping("/editBaseProduct/{idBaseProduct}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasRole('ADMIN')")
	BaseProductDto editBaseProduct(@RequestBody BaseProductDto baseProductDto, @PathVariable long idBaseProduct) {
		return baseProductManagerService.editBaseProduct(baseProductDto, idBaseProduct);
	}

	@GetMapping("/findBaseProduct/{idBaseProduct}")
	BaseProductDto findBaseProduct(@PathVariable long idBaseProduct) {
		return baseProductManagerService.findBaseProduct(idBaseProduct);
	}

	@GetMapping("/finBaseProductForNeeds/{idNeeds}")
	List<BaseProductDto> finBaseProductForNeeds(@PathVariable long idNeeds) {
		return baseProductManagerService.finBaseProductForNeeds(idNeeds);
	}

	@DeleteMapping("/deleteBaseProduct/{idBaseProduct}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasRole('ADMIN')")
	void deleteBaseProduct(@PathVariable long idBaseProduct) {
		baseProductManagerService.deleteBaseProduct(idBaseProduct);
	}

	@GetMapping("/baseProductNameExists/checkedName/{checkedName}")
	boolean baseProductNameExists(@PathVariable String checkedName) {
		return baseProductManagerService.baseProductNameExists(checkedName);
	}
	
}
