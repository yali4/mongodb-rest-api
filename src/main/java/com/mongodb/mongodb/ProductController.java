package com.mongodb.mongodb;

import com.mongodb.mongodb.Collection.Product;
import com.mongodb.mongodb.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping()
    public void createProducts(@RequestBody List<Product> productList) {
        for (Product product: productList) {
            productRepository.save(product);
        }
    }

    @GetMapping()
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("name/{query}")
    public List<Product> getProductsByName(@PathVariable("query") String searchQuery) {
        return productRepository.findProductsByName(searchQuery);
    }

    @GetMapping("price/{price1}-{price2}")
    public List<Product> getProductsByPrice(@PathVariable("price1") Double price1, @PathVariable("price2") Double price2) {
        return productRepository.findProductByPrice(price1, price2);
    }

}
