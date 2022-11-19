package org.db.connectors.repository;

import org.db.connectors.SqlUtils;
import org.db.connectors.model.MariaDbModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MariaDbRepositoryImpl implements MariaDbRepository {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void insertMariaDbModel(MariaDbModel mariaDbModel) {
        final MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("productId", mariaDbModel.getProductId());
        paramSource.addValue("product_name", mariaDbModel.getProductName());

        jdbcTemplate.update(SqlUtils.CREATE_PRODUCT_MARIA_DB, paramSource);

    }
}
