package com.example.projectmanagement.service;

import com.example.projectmanagement.model.Product;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface ProductService {

    public Product saveProduct(Product product);

    public List<Product> getAllProduct();

    public Product getProductById(Integer id);

    public String deleteProduct(Integer id);

    public Product editProduct(Integer id, Product product);

}
