package org.db.connectors.controller;

import org.db.connectors.model.Product;
import org.db.connectors.service.ProductMariaDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    ProductMariaDbService productMariaDbService;

    @RequestMapping(value = "mariaDB/insertProduct", method = RequestMethod.POST)
    public String insertMariaDbModel(@RequestBody Product product) throws Exception {
        return productMariaDbService.insertMariaDbModel(product);
    }

    @RequestMapping(value = "mariaDB/getProductById", method = RequestMethod.GET)
    public Product getMariaDBProduct(@RequestParam String productId) throws Exception {
        return productMariaDbService.getProductById(productId);
    }


}
