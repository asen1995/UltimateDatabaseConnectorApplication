package org.db.connectors.service;

import org.db.connectors.model.MariaDbModel;
import org.db.connectors.repository.MariaDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MariaDbServiceImpl implements MariaDbService {

    @Autowired
    MariaDbRepository mariaDbRepository;

    @Override
    public String insertMariaDbModel(MariaDbModel mariaDbModel) {
        mariaDbRepository.insertMariaDbModel(mariaDbModel);
        return null;
    }
}
