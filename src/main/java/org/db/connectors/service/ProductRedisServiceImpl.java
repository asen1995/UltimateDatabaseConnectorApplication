package org.db.connectors.service;

import org.db.connectors.model.Product;
import org.db.connectors.model.RedisProductList;
import org.db.connectors.repository.ProductRedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductRedisServiceImpl implements ProductRedisService {

    @Autowired
    ProductRedisRepository productRedisRepository;

    @Override
    public String insertRedisProduct(Product product) {
        return productRedisRepository.insertRedisProduct(product);
    }

    @Override
    public Product getProductById(String productId) {
        return productRedisRepository.getProductById(productId);
    }

    @Override
    public List<Product> getListProducts(String productListKey) {
        return productRedisRepository.getListProducts(productListKey);
    }

    @Override
    public String deleteProduct(String productId) {
        return productRedisRepository.deleteProduct(productId);
    }

    @Override
    public String insertRedisListProduct(RedisProductList redisProductList) {
        return productRedisRepository.insertRedisProducts(redisProductList);
    }
}
