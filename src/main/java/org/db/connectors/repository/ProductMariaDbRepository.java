package org.db.connectors.repository;

import org.db.connectors.model.Product;

public interface ProductMariaDbRepository {
    void insertMariaDbModel(Product product);

    Product getProductById(String productId);
}
