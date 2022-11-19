package org.db.connectors.service;

import org.db.connectors.model.Product;
import org.db.connectors.repository.MariaDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MariaDbServiceImpl implements MariaDbService {

    @Autowired
    MariaDbRepository mariaDbRepository;

    @Override
    public String insertMariaDbModel(Product product) {
        mariaDbRepository.insertMariaDbModel(product);
        return null;
    }
}
