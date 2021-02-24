package org.capiskinserver.mailling.controller;


import java.util.HashMap;
import java.util.Map;

import org.capiskinserver.mailling.dto.MailContactRequestDto;
import org.capiskinserver.mailling.dto.MailResponseDto;
import org.capiskinserver.mailling.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class EmailContactController {

	@Autowired
	private EmailService service;

	@PostMapping("/receiveEmail")
	public MailResponseDto receiveContactEmail(@RequestBody MailContactRequestDto request) {
		Map<String, Object> model = new HashMap<>();
		model.put("Name", request.getName());
		model.put("Email", request.getEmail());
		model.put("Subject", request.getSubject());
		model.put("Message", request.getMessage());
		model.put("location", "France,Paris");
		return service.receiveContactEmail(request, model);
	}

}
