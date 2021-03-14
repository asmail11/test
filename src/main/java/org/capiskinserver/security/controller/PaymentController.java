package org.capiskinserver.security.controller;

import org.capiskinserver.security.model.PaymentDto;
import org.capiskinserver.security.services.PaymentManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class PaymentController {
	
	@Autowired
	private PaymentManagerService paymentManagerService;
	
	@PostMapping("/addPayment/{idUser}")
	PaymentDto addPayment(@RequestBody PaymentDto paymentDto, @PathVariable long idUser) {
		return paymentManagerService.addPayment(paymentDto, idUser);
	}
	@GetMapping("/findPaymentForUser/{idUser}")
	PaymentDto findPaymentForUser(@PathVariable long idUser) {
		return paymentManagerService.findPaymentForUser(idUser);
	}
	@PutMapping("/updatePayment/{idPayment}")
	PaymentDto updatePayment(@RequestBody PaymentDto paymentDto, @PathVariable long idPayment) {
		return paymentManagerService.updatePayment(paymentDto, idPayment);
	}
	
	@GetMapping("/validatedCreditCardNumber/{input}")
	boolean validatedCreditCardNumber(@PathVariable String input) {
		return paymentManagerService.validatedCreditCardNumber(input);
	}
	@DeleteMapping("/deletePayment/{idUser}/{idPayment}")
	void deletePayment(@PathVariable long idUser, @PathVariable long idPayment) {
		paymentManagerService.deletePayment(idUser, idPayment);
	}
}
