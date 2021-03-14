package org.capiskinserver.security.services.impl;

import javax.transaction.Transactional;

import org.capiskinserver.exception.AlreadyExistsException;
import org.capiskinserver.security.model.Payment;
import org.capiskinserver.security.model.User;
import org.capiskinserver.security.repository.PaymentDao;
import org.capiskinserver.security.services.PaymentDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PaymentDomainServiceImpl implements PaymentDomainService {

	@Autowired
	private PaymentDao paymentDao;

	@Override
	public Payment addPayment(Payment payment, User user) {
		if (validatedCreditCardNumber(payment.getCartNumber())) {
		if (payment != null && user != null) {
			payment.setUser(user);
			user.setPayment(payment);
			return paymentDao.save(payment);
		}
	 } else {
		 throw new AlreadyExistsException("is an invalid credit card number");
	}
		return null;
	}

	@Override
	public Payment updatePayment(Payment payment, Payment existPayment) {
		
		if (validatedCreditCardNumber(payment.getCartNumber())) {
			if (payment != null && existPayment != null) {
				existPayment.setCartNumber(payment.getCartNumber());
				existPayment.setNameOnCard(payment.getNameOnCard());
				existPayment.setExpiry(payment.getExpiry());
				existPayment.setCryptogram(payment.getCryptogram());
				return paymentDao.save(existPayment);
			}
		} else {
			throw new AlreadyExistsException("is an invalid credit card number");
		}

		return null;
	}

	@Override
	public boolean validatedCreditCardNumber(String input) {

		int[] ints = new int[input.length()];
		for (int i = 0; i < input.length(); i++) {
			ints[i] = Integer.parseInt(input.substring(i, i + 1));
		}
		for (int i = ints.length - 2; i >= 0; i = i - 2) {
			int j = ints[i];
			j = j * 2;
			if (j > 9) {
				j = j % 10 + 1;
			}
			ints[i] = j;
		}
		int sum = 0;
		for (int i = 0; i < ints.length; i++) {
			sum += ints[i];
		}
		if (sum % 10 == 0) {
			System.out.println(input + " is a valid credit card number");
			return true;
		} else {
			System.out.println(input + " is an invalid credit card number");
			return false;
		}

	}

}
