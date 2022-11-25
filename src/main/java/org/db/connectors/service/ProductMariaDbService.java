package org.db.connectors.service;

import org.db.connectors.model.Product;

public interface ProductMariaDbService {
    String insertMariaDbModel(Product product);

    Product getProductById(String productId);
}
