package com.monish.Spring_Ecom.Controller;

import com.monish.Spring_Ecom.model.Products;
import com.monish.Spring_Ecom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/products")
    public ResponseEntity<List<Products>> getProducts(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Products> getDetails(@PathVariable("id")int id){
        Products products = productService.getDetails(id);
        if(products.getId()>0)
            return new ResponseEntity<>(products,HttpStatus.FOUND);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    //Adding image into database with all new product
    @PostMapping("/product")
    public ResponseEntity<?> addImage(@RequestPart Products products, @RequestPart MultipartFile image){
        Products savedProduct = null;
        try {
            savedProduct = productService.addOrUpdateProduct(products, image);
            return new ResponseEntity<>(savedProduct,HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    //Getting image using productID
    @GetMapping("/product/{productId}/image")
    public ResponseEntity<byte[]> getImageByProductId(@PathVariable int productId){
        Products products=productService.getProductById(productId);
        if(products.getId()>0)
            return new ResponseEntity<>(products.getImageData(),HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    //Updating data
    @PutMapping("/product/update/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id,@RequestPart Products products, @RequestPart MultipartFile image){
        Products savedProduct = null;
        try {
            savedProduct = productService.addOrUpdateProduct(products, image);
            return new ResponseEntity<>("Updated",HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
