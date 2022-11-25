package org.db.connectors.controller;

import org.db.connectors.model.Product;
import org.db.connectors.service.ProductMariaDbService;
import org.db.connectors.service.ProductRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    ProductMariaDbService productMariaDbService;

    @Autowired
    ProductRedisService productRedisService;

    @RequestMapping(value = "mariaDB/insertProduct", method = RequestMethod.POST)
    public String insertMariaProduct(@RequestBody Product product) {
        return productMariaDbService.insertMariaDbModel(product);
    }

    @RequestMapping(value = "mariaDB/getProductById", method = RequestMethod.GET)
    public Product getMariaDBProduct(@RequestParam String productId) {
        return productMariaDbService.getProductById(productId);
    }

    @RequestMapping(value = "redis/insertProduct", method = RequestMethod.POST)
    public String insertRedisProduct(@RequestBody Product product) {
        return productRedisService.insertRedisProduct(product);
    }


}
