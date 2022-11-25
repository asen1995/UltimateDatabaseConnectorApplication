package org.db.connectors.service;

import org.db.connectors.model.Product;
import org.db.connectors.repository.ProductRedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductRedisServiceImpl implements ProductRedisService {

    @Autowired
    ProductRedisRepository productRedisRepository;
    @Override
    public String insertRedisProduct(Product product) {
        return productRedisRepository.insertRedisProduct(product);
    }
}
