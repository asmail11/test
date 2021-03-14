package org.capiskinserver.security.services;

import org.capiskinserver.security.model.Payment;
import org.capiskinserver.security.model.User;
import org.springframework.stereotype.Service;

@Service
public interface PaymentDomainService {
	
	Payment addPayment(Payment payment, User user);
	
	Payment updatePayment(Payment payment, Payment existPayment);
	
	boolean validatedCreditCardNumber(String input);

}
