package org.db.connectors.repository;

import org.db.connectors.model.Product;

public interface MariaDbRepository {
    void insertMariaDbModel(Product product);

    Product getProductById(String productId);
}
