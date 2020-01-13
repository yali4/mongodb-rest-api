package com.mongodb.mongodb.Repository;

import com.mongodb.mongodb.Collection.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {

    @Query("{ 'name' : { $regex: ?0 }  }")
    List<Product> findProductsByName(String name);

    @Query("{ 'price' : { $gt: ?0, $lt: ?1 } }")
    List<Product> findProductByPrice(Double price1, Double price2);

}
