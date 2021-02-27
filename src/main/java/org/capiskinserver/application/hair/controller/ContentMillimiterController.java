package org.capiskinserver.application.hair.controller;

import org.capiskinserver.application.hair.dto.ContentMillimiterDto;
import org.capiskinserver.application.hair.service.ContentMillimiterManagerService;
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
public class ContentMillimiterController extends RestBaseController {

	@Autowired
	private ContentMillimiterManagerService contentMillimiterManagerService;

	@PostMapping("/addContentMillimiter/{idFinalProduct}")
	ContentMillimiterDto addContentMillimiter(@RequestBody ContentMillimiterDto contentMillimiterDto,
			@PathVariable long idFinalProduct) {
		return contentMillimiterManagerService.addContentMillimiter(contentMillimiterDto, idFinalProduct);
	}

	@PutMapping("/editContentMillimiter/{idContentMillimiter}")
	ContentMillimiterDto editContentMillimiter(@RequestBody ContentMillimiterDto contentMillimiterDto,
			@PathVariable long idContentMillimiter) {
		return contentMillimiterManagerService.editContentMillimiter(contentMillimiterDto, idContentMillimiter);
	}

	@GetMapping("/findContentMillimiter/{idContentMillimiter}")
	ContentMillimiterDto findContentMillimiter(@PathVariable long idContentMillimiter) {
		return contentMillimiterManagerService.findContentMillimiter(idContentMillimiter);
	}

	@DeleteMapping("/deleteContentMillimiter/{idContentMillimiter}/{idFinalProduct}")
	void deleteContentMillimiter(@PathVariable long idContentMillimiter, @PathVariable long idFinalProduct) {
		contentMillimiterManagerService.deleteContentMillimiter(idContentMillimiter, idFinalProduct);
		;
	}

	@GetMapping("/findContentMillimiterForProduct/{idFinalProduct}")
	ContentMillimiterDto findContentMillimiterForProduct(@PathVariable long idFinalProduct) {
		return contentMillimiterManagerService.findContentMillimiterForProduct(idFinalProduct);
	}

}
