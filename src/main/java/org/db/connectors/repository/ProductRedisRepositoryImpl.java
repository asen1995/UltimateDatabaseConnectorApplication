package org.db.connectors.repository;

import org.db.connectors.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;

@Repository
public class ProductRedisRepositoryImpl implements ProductRedisRepository {

    @Autowired(required = false)
    Jedis jedis;

    @Override
    public String insertRedisProduct(Product product) {
        return jedis.set(String.valueOf(product.getProductId()), product.getProductName());
    }

    @Override
    public Product getProductById(String productId) {
        final String productName = jedis.get(productId);
        if (productName == null || productName.isEmpty()) {
            throw new RuntimeException(String.format("Can't find product with productId %s ", productId));
        }
        return new Product(Integer.parseInt(productId), productName);
    }
}
