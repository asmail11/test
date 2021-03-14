package org.capiskinserver.security.repository;

import org.capiskinserver.security.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDao extends JpaRepository<Payment, Long> {

}
