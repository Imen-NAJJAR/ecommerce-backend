package com.telusko.ecom_project.service;

import com.telusko.ecom_project.model.Product;
import com.telusko.ecom_project.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepo product;
    public List< Product> getAllProducts() {
        return product.findAll();
    }

    public Product getProduct(int prodId) {
        return product.findById(prodId).orElse(new Product());
    }

    public Product addProduct(Product product1, MultipartFile image) throws IOException {
        product1.setImageName(image.getOriginalFilename());
        product1.setImageType(image.getContentType());
        product1.setImageData(image.getBytes());
        return product.save(product1);
    }

    public Product updateProduct(int id, Product product1, MultipartFile image) throws IOException {
        product1.setImageName(image.getOriginalFilename());
        product1.setImageType(image.getContentType());
        product1.setImageData(image.getBytes());
        return product.save(product1);
    }

    public void deleteProduct(int id) {
        product.deleteById(id);
    }


    public List<Product> searchProducts(String keyword) {
        return product.searchProducts(keyword);
    }
}
