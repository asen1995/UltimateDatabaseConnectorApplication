package org.db.connectors.repository;

import org.db.connectors.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;

@Repository
public class ProductRedisRepositoryImpl implements ProductRedisRepository {

    @Autowired
    Jedis jedis;

    @Override
    public String insertRedisProduct(Product product) {
        return jedis.set(String.valueOf(product.getProductId()), product.getProductName());
    }
}
