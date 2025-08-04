package com.monish.Junit_Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }
}
