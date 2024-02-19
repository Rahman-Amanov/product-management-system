package com.example.projectmanagement.service;

import com.example.projectmanagement.model.Product;
import com.example.projectmanagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;


    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.findById(id).get();
    }

    @Override
    public String deleteProduct(Integer id) {
        Product product=productRepository.findById(id).get();

        if(product!=null){
            productRepository.delete(product);
            return "Product Deleted Successfully";
        }

        return "Something wrong on server";
    }

    @Override
    public Product editProduct(Integer id, Product product) {

        Product oldProduct=productRepository.findById(id).get();
        oldProduct.setProductName(product.getProductName());
        oldProduct.setDescription(product.getDescription());
        oldProduct.setPrice(product.getPrice());
        oldProduct.setStatus(product.getStatus());

        return productRepository.save(oldProduct);
    }
}
