package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class QueryMethodTests {
    @Autowired
    ProductRepository productRepository;

    // testing our find by name method
    @Test
    public void testFindByName() {
        Product product = productRepository.findByName("Test 1");
    }

    // testing our find by id method, we get optional product object by using get()
    @Test
    public void testFindById() {
        Product product = productRepository.findById(1L).get();
    }

    // test find by name description
    @Test
    public void testFinByNameAndDescription() {
        List<Product> product = productRepository.findByNameAndDescription
                ("Test 1" , "testing 1");
        product.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    // test or condition
    @Test
    public void testFinByNameOrDescription() {
        List<Product> product = productRepository.findByNameOrDescription
                ("Test 1" , "testing 2");
        product.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    // finding unique field
    @Test
    public void testDistinctByName() {
        Product product = productRepository.findDistinctByName("Test 1");
        System.out.println(product);
    }

    // test greater than method of jpa
    @Test
    public void testFindByGreaterThan() {
        List<Product> product = productRepository.findByPriceGreaterThan(BigDecimal.valueOf(3.9));
        product.forEach((p) -> {
            System.out.println(p.getName());
        });
    }

    // test less than method of jpa
    @Test
    public void testFindByLessThan() {
        List<Product> product = productRepository.findByPriceLessThan(BigDecimal.valueOf(200));
        product.forEach((p) -> {
            System.out.println(p.getName());
        });
    }

    // test containing method of jpa
    @Test
    public void testFindByContaining() {
        List<Product> product = productRepository.findByNameContaining("est");
        product.forEach((p) -> {
            System.out.println(p.getName());
        });
    }

    // test like method of jpa
    @Test
    public void testFindByLike() {
        List<Product> product = productRepository.findBySkuLike("unit 1");
        System.out.println(product);
    }

    // test between method of jpa
    @Test
    public void testFindByBetween() {
        List<Product> product = productRepository.findByPriceBetween
                (new BigDecimal(100), new BigDecimal(400));
        product.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    // test in method of jpa
    @Test
    public void testFindByIn() {
        List<Product> product = productRepository.findByDescriptionIn
                (List.of("testing 1", "product 3"));
        product.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    // test limit method of jpa
    @Test
    public void testFindByLimit() {
        List<Product> product = productRepository.findFirst3ByOrderByNameDesc();
        product.forEach((p) -> {
            System.out.println(p.getName());
        });
    }
}
