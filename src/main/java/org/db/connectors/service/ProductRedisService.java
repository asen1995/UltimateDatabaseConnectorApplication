package org.db.connectors.service;

import org.db.connectors.model.Product;
import org.db.connectors.model.RedisProductList;

public interface ProductRedisService {
    String insertRedisProduct(Product product);

    Product getProductById(String productId);

    String deleteProduct(String productId);

    String insertRedisListProduct(RedisProductList product);
}
