package org.db.connectors.service;

import org.db.connectors.model.Product;
import org.db.connectors.repository.ProductMariaDBJpaRepository;
import org.db.connectors.repository.ProductMariaDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductMariaDbServiceImpl implements ProductMariaDbService {

    @Autowired
    ProductMariaDbRepository productMariaDbRepository;

    @Autowired
    ProductMariaDBJpaRepository productMariaDBJpaRepository;

    @Override
    public String insertMariaDbModel(Product product) {
        productMariaDbRepository.insertMariaDbModel(product);
        return null;
    }

    @Override
    public Product getProductById(String productId) {
        return productMariaDbRepository.getProductById(productId);
    }

    @Override
    public Product getProductByIdJpa(String productId) {
        return productMariaDBJpaRepository.getOne(productId);
    }

    @Override
    public Product getProductByIdJpa2(String productId) {
        return productMariaDBJpaRepository.findById(productId).get();
    }
}
