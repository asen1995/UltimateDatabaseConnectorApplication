package org.db.connectors.service;

import org.db.connectors.model.Product;

public interface ProductRedisService {
    String insertRedisProduct(Product product);

    Product getProductById(String productId);

    String deleteProduct(String productId);
}
