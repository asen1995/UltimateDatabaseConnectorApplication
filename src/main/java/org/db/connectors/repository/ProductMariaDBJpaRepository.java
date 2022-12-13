package org.db.connectors.repository;

import org.db.connectors.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductMariaDBJpaRepository extends JpaRepository<Product, String> {

}
