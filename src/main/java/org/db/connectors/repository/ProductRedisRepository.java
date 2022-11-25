package org.db.connectors.repository;

import org.db.connectors.model.Product;

public interface ProductRedisRepository {
    String insertRedisProduct(Product product);
}
