package org.db.connectors.service;

import org.db.connectors.model.Product;

public interface MariaDbService {
    String insertMariaDbModel(Product product);

    Product getProductById(String productId);
}
