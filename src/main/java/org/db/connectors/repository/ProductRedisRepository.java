package org.db.connectors.repository;

import org.db.connectors.model.Product;

public interface ProductRedisRepository {
    String insertRedisProduct(Product product);

    Product getProductById(String productId);

    String deleteProduct(String productId);
}
