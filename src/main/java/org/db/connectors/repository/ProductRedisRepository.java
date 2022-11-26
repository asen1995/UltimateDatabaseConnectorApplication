package org.db.connectors.repository;

import org.db.connectors.model.Product;
import org.db.connectors.model.RedisProductList;

import java.util.List;

public interface ProductRedisRepository {
    String insertRedisProduct(Product product);

    Product getProductById(String productId);

    String deleteProduct(String productId);

    String insertRedisProducts(RedisProductList redisProductList);

    List<Product> getListProducts(String productListKey);
}
