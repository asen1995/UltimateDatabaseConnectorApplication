package org.db.connectors.repository;

import org.db.connectors.SQLResources;
import org.db.connectors.model.Product;
import org.db.connectors.rm.ProductRowMapperMariaDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class ProductMariaDbRepositoryImpl implements ProductMariaDbRepository {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void insertMariaDbModel(Product product) {
        final MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("productId", product.getProductId());
        paramSource.addValue("product_name", product.getProductName());

        jdbcTemplate.update(SQLResources.CREATE_PRODUCT_MARIA_DB, paramSource);

    }

    @Override
    public Product getProductById(String productId) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("productId", productId);
        final Product product = jdbcTemplate.queryForObject(SQLResources.GET_PRODUCT_BY_ID_MARIA_DB, namedParameters, new ProductRowMapperMariaDB());
        return product;
    }
}
