package org.db.connectors.repository;

import org.db.connectors.model.MariaDbModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class MariaDbRepositoryImpl implements MariaDbRepository {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void insertMariaDbModel(MariaDbModel mariaDbModel) {
        //TODO implement jdbc query
        jdbcTemplate.update("", (SqlParameterSource) null);

    }
}
