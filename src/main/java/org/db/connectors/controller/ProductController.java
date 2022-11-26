package org.db.connectors.controller;

import org.db.connectors.model.Product;
import org.db.connectors.model.RedisProductList;
import org.db.connectors.service.ProductMariaDbService;
import org.db.connectors.service.ProductRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping(value = "redis/product", method = RequestMethod.POST)
    public String insertRedisProduct(@RequestBody Product product) {
        return productRedisService.insertRedisProduct(product);
    }

    @RequestMapping(value = "redis/product/list", method = RequestMethod.POST)
    public String insertRedisListProduct(@RequestBody RedisProductList redisProductList) {
        return productRedisService.insertRedisListProduct(redisProductList);
    }

    @RequestMapping(value = "redis/product", method = RequestMethod.GET)
    public Product getRedisProduct(@RequestParam String productId) {
        return productRedisService.getProductById(productId);
    }

    @RequestMapping(value = "redis/product/list", method = RequestMethod.GET)
    public List<Product> getRedisListProduct(@RequestParam String productListKey) {
        return productRedisService.getListProducts(productListKey);
    }

    @RequestMapping(value = "redis/product", method = RequestMethod.DELETE)
    public String deleteRedisProduct(@RequestParam String productId) {
        return productRedisService.deleteProduct(productId);
    }


}
