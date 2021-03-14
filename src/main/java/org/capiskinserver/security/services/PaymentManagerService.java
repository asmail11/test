package org.capiskinserver.security.services;

import org.capiskinserver.security.model.PaymentDto;
import org.springframework.stereotype.Service;

@Service
public interface PaymentManagerService {
	
	PaymentDto addPayment(PaymentDto paymentDto, long idUser);
	
	PaymentDto findPaymentForUser(long idUser);
	
	PaymentDto updatePayment(PaymentDto paymentDto, long idPayment);
	
	boolean validatedCreditCardNumber(String input);
	
	void deletePayment(long idUser, long idPayment);

}
