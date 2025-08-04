package com.monish.Spring_Ecom.service;

import com.monish.Spring_Ecom.Repository.ProductRepo;
import com.monish.Spring_Ecom.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo repo;

    public List<Products> getAllProducts() {
        return repo.findAll();
    }

    public Products getDetails(int id) {
        return repo.findById(id).orElse(new Products(-1));
    }

    public Products addOrUpdateProduct(Products products, MultipartFile image) throws IOException {
        products.setImageName(image.getOriginalFilename());
        products.setImageType(image.getContentType());
        products.setImageData(image.getBytes());
        return repo.save(products);
    }

    public Products getProductById(int productId) {
        return repo.findById(productId).get();
    }
}
