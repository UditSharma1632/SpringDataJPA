package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

     Product findByName(String name);
     Optional<Product> findById(Long id);

     // list of products with matching name and description
     List<Product> findByNameAndDescription(String name, String description);

     // Using or condition
     List<Product> findByNameOrDescription(String name, String description);

     // finding unique fields
     Product findDistinctByName(String name);

     // finding greater than
     List<Product> findByPriceGreaterThan(BigDecimal price);

     // finding greater than
     List<Product> findByPriceLessThan(BigDecimal price);

     // finding containing
     List<Product> findByNameContaining(String name);

     // finding byLike
     List<Product> findBySkuLike(String sku);

    // finding between
     List<Product> findByPriceBetween(BigDecimal firstprice, BigDecimal secondprice);

     // finding in
     List<Product> findByDescriptionIn(List<String> names);

     // limiting query results
     List<Product> findFirst3ByOrderByNameDesc();
}
