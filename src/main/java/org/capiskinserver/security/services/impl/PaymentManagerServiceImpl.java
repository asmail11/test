package org.capiskinserver.security.services.impl;

import javax.transaction.Transactional;

import org.capiskinserver.domain.hair.OrikaBeanMapper;
import org.capiskinserver.security.model.Payment;
import org.capiskinserver.security.model.PaymentDto;
import org.capiskinserver.security.model.User;
import org.capiskinserver.security.repository.PaymentDao;
import org.capiskinserver.security.repository.UserRepository;
import org.capiskinserver.security.services.PaymentDomainService;
import org.capiskinserver.security.services.PaymentManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PaymentManagerServiceImpl implements PaymentManagerService {
	
	private OrikaBeanMapper orikaBeanMapper;
	
	private PaymentDomainService paymentDomainService;
	
	private UserRepository userRepository;
	
	private PaymentDao paymentDao;

	@Autowired
	public PaymentManagerServiceImpl(OrikaBeanMapper orikaBeanMapper, PaymentDomainService paymentDomainService,
			UserRepository userRepository, PaymentDao paymentDao) {
		super();
		this.orikaBeanMapper = orikaBeanMapper;
		this.paymentDomainService = paymentDomainService;
		this.userRepository = userRepository;
		this.paymentDao = paymentDao;
	}

	@Override
	public PaymentDto addPayment(PaymentDto paymentDto, long idUser) {
		Payment payment = orikaBeanMapper.map(paymentDto, Payment.class);
		User user = userRepository.getOne(idUser);
		return orikaBeanMapper.convertDTO(paymentDomainService.addPayment(payment, user), PaymentDto.class);
	}

	@Override
	public PaymentDto findPaymentForUser(long idUser) {
		User user = userRepository.getOne(idUser);
		return orikaBeanMapper.convertDTO(user.getPayment(), PaymentDto.class);
	}

	@Override
	public PaymentDto updatePayment(PaymentDto paymentDto, long idPayment) {
		Payment payment = orikaBeanMapper.map(paymentDto, Payment.class);
		Payment existPayment = paymentDao.getOne(idPayment);
		return orikaBeanMapper.convertDTO(paymentDomainService.updatePayment(payment, existPayment), PaymentDto.class);
	}

	@Override
	public boolean validatedCreditCardNumber(String input) {
		return paymentDomainService.validatedCreditCardNumber(input);
	}

	@Override
	public void deletePayment(long idUser, long idPayment) {
		User user = userRepository.getOne(idUser);
		Payment existPayment = paymentDao.getOne(idPayment);
		user.setPayment(null);
		paymentDao.delete(existPayment);
	}
	
	

}
