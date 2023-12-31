package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveTest(){
        Product product = new Product();
        product.setName("Test");
        product.setDescription("testing");
        product.setPrice(BigDecimal.valueOf(330.9));
        product.setSku("unit");
        product.setActive(true);
        product.setImageUrl("png");

        Product savedResult = productRepository.save(product);
        System.out.println(savedResult.toString());
    }

    @Test
    void updateTest(){

        // find by id
        Long id = 1L;

        // Here we search for a product in repo with id 1 and use get to retrieve back the product
        Product product = productRepository.findById(id).get();

        // set new values
        product.setSku("Updated sku");
        product.setName("Updated name");

        // save updated values in repo
        productRepository.save(product);

        System.out.println(product);
    }

    @Test
    void testFindById(){

        Long id = 1L;
        Product product = productRepository.findById(id).get();
    }

    @Test
    void testSaveAll(){
        Product product2 = new Product();
        product2.setName("Test 3");
        product2.setDescription("testing 3");
        product2.setPrice(BigDecimal.valueOf(330));
        product2.setSku("unit 3");
        product2.setActive(true);
        product2.setImageUrl("png3");

        Product product3 = new Product();
        product3.setName("Test 4");
        product3.setDescription("testing 4");
        product3.setPrice(BigDecimal.valueOf(440.9));
        product3.setSku("unit 4");
        product3.setActive(true);
        product3.setImageUrl("png4");

        Product product4 = new Product();
        product4.setName("Test 5");
        product4.setDescription("testing 5");
        product4.setPrice(BigDecimal.valueOf(550.9));
        product4.setSku("unit 5");
        product4.setActive(true);
        product4.setImageUrl("png5");

        Product product5 = new Product();
        product5.setName("Test 6");
        product5.setDescription("testing 6");
        product5.setPrice(BigDecimal.valueOf(660.9));
        product5.setSku("unit 6");
        product5.setActive(true);
        product5.setImageUrl("png6");

        // Here we create a list of product objects using List.of method
        productRepository.saveAll(List.of(product2, product3, product4, product5));
    }

    @Test
    void testFindAll(){

        List<Product> product = productRepository.findAll();
        product.forEach((p) -> {
            System.out.println(p.getName());
        });
    }

    @Test
    void testDeleteById(){

        Long id = 2L;
        productRepository.deleteById(id);
    }

    @Test
    void testDeleteMethod(){

       // first find that entity by id, again remember we received product object using get method
        Long id = 1L;
        Product deletedProduct = productRepository.findById(id).get();

        //Delete product
        productRepository.delete(deletedProduct);
    }

    @Test
    void testDeleteAllMethod(){

        //Delete all products
        productRepository.deleteAll();

        // Delete all products using iterable deleteAll method
            // first get multiple objects from repo by ID
        Product product1 = productRepository.findById(6L).get();
        Product product2 = productRepository.findById(7L).get();

        productRepository.deleteAll(List.of(product1, product2));
    }

    @Test
    void testCount(){

        long count = productRepository.count();
        System.out.println(count);
    }

    @Test
    void testExistById(){

        Long id = 8L;
        boolean result = productRepository.existsById(id);
        System.out.println(result);
    }

}