package org.db.connectors.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RedisProductList {
    private String key;
    private List<Product> product;
}
