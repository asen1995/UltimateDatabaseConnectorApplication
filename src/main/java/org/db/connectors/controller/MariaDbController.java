package org.db.connectors.controller;

import org.db.connectors.model.Product;
import org.db.connectors.service.MariaDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MariaDbController {

    @Autowired
    MariaDbService mariaDbService;

    @RequestMapping(value = "insertMariaDbModel", method = RequestMethod.POST)
    public String insertMariaDbModel(@RequestBody Product product) throws Exception {
        return mariaDbService.insertMariaDbModel(product);
    }

    @RequestMapping(value = "getProductById", method = RequestMethod.GET)
    public Product insertMariaDbModel(@RequestParam String productId) throws Exception {
        return mariaDbService.getProductById(productId);
    }


}
