package org.db.connectors.repository;

import org.db.connectors.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
        final String productName = jedisPool.getResource().get(productId);
        if (productName == null || productName.isEmpty()) {
            throw new RuntimeException(String.format("Can't find product with productId %s ", productId));
        }
        return new Product(Integer.parseInt(productId), productName);
    }

    @Override
    public String deleteProduct(String productId) {
        final Long del = jedisPool.getResource().del(productId);

        if (del != 1) {
            return String.format("product with %s don't exists", productId);
        }
        return "SUCCESS";
    }
}
