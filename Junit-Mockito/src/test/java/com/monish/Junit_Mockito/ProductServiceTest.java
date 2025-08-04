package com.monish.Junit_Mockito;

import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    ProductRepo productRepo;
    @InjectMocks
    ProductService productService;                 //Service is dependent on repo

    @BeforeAll                                     //Before all is a class level test which is executed first and only once
    public static void init(){
        System.out.println("Before all the tests");
    }
    @BeforeEach                                    //Before each is executed before every test
    public void initBeforeEach(){
        System.out.println("Before every test");
    }
    @Test
    void addProductShouldAddProductSuccessfully(){
        Product product = new Product();                                 //Creating a new product to test
        product.setId(1);
        product.setName("glass");
        product.setPrice(200);
        Mockito.when(productRepo.save(product)).thenReturn(product);     //The saved product is sent back
        Product addedProduct=productService.addProduct(product);         //adding the saved product to another product to test

        //testing product == addedproduct
        //Assestions are used to compare against some values
        Assertions.assertNotNull(addedProduct);
        Assertions.assertEquals(product.getId(),addedProduct.getId());
        Assertions.assertEquals(product.getName(),addedProduct.getName());
        Assertions.assertEquals(product.getName(),addedProduct.getName());
        System.out.println("Adding product successful");
    }
    @Test
    void dummyTest(){
        System.out.println("Dummy test");
    }

    @AfterEach
    public void destroy(){
        System.out.println("after each test");
    }
    @AfterAll
    public static void disconnect(){
        System.out.println("After all the tests");
    }
}
