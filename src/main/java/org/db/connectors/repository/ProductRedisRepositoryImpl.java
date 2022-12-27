package org.db.connectors.repository;

import org.db.connectors.model.Product;
import org.db.connectors.model.RedisProductList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRedisRepositoryImpl implements ProductRedisRepository {

    @Autowired(required = false)
    JedisPool jedisPool;

    @Override
    public String insertRedisProduct(Product product) {
        return jedisPool.getResource().set(String.valueOf(product.getProductId()), product.getProductName());
    }

    @Override
    public String insertRedisProducts(RedisProductList redisProductList) {
        final Long lpush = jedisPool.getResource().lpush(redisProductList.getKey(), redisProductList.getProduct()
                .stream().map(Product::getProductName)
                .toArray(String[]::new));
        if (lpush == 0) {
            return String.format("product list with key %s can't be saved ! ", redisProductList.getKey());
        }
        return "SUCCESS";
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
    public List<Product> getListProducts(String productListKey) {
        return jedisPool.getResource().lrange(productListKey, 0, 1000).stream()
                .map(productName -> new Product(0, productName))
                .collect(Collectors.toList());
    }

    @Override
    public String deleteProduct(String productId) {
        final Long del = jedisPool.getResource().del(productId);

        if (del != 1) {
            return String.format("product with %s don't exists", productId);
        }
        return "SUCCESS";
    }


    public String deleteProductList(String productListKey) {
        final Long del = jedisPool.getResource().del(productListKey);

        if (del != 1) {
            return String.format("product list with %s don't exists", productListKey);
        }
        return "SUCCESS";
    }

    public String clearAll() {
        jedisPool.getResource().flushAll();
        return "SUCCESS";
    }
}
