package org.db.connectors.repository;

import org.db.connectors.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Repository
public class ProductRedisRepositoryImpl implements ProductRedisRepository {

    @Autowired(required = false)
    JedisPool jedisPool;

    @Override
    public String insertRedisProduct(Product product) {
        return jedisPool.getResource().set(String.valueOf(product.getProductId()), product.getProductName());
    }

    @Override
    public Product getProductById(String productId) {
        final Jedis jedisConnection = jedisPool.getResource();
        final String productName = jedisConnection.get(productId);
        if (productName == null || productName.isEmpty()) {
            throw new RuntimeException(String.format("Can't find product with productId %s ", productId));
        }
        return new Product(Integer.parseInt(productId), productName);
    }
}
