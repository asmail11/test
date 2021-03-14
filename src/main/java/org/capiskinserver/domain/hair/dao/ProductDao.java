package org.capiskinserver.domain.hair.dao;

import org.capiskinserver.domain.hair.modal.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {
	Boolean existsByName(String name);
}
