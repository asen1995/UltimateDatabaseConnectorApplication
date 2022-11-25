package org.db.connectors.service;

import org.db.connectors.model.Product;
import org.db.connectors.repository.ProductMariaDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductMariaDbServiceImpl implements ProductMariaDbService {

    @Autowired
    ProductMariaDbRepository productMariaDbRepository;

    @Override
    public String insertMariaDbModel(Product product) {
        productMariaDbRepository.insertMariaDbModel(product);
        return null;
    }

    @Override
    public Product getProductById(String productId) {
        return productMariaDbRepository.getProductById(productId);
    }
}
