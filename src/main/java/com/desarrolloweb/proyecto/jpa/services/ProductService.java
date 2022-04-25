package com.desarrolloweb.proyecto.jpa.services;

import java.util.List;
import java.util.Optional;

import com.desarrolloweb.proyecto.jpa.model.Product;
import com.desarrolloweb.proyecto.jpa.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public boolean addProduct(Product product) {
        productRepository.save(product);
        return false;
    }

    @Override
    public boolean deleteProduct(Product product) {
        Optional<Product> productOptional = productRepository.findById(product.getId());
        if(productOptional.isPresent())
        {
            productRepository.delete(productOptional.get());
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteProduct(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isPresent())
        {
            productRepository.delete(productOptional.get());
            return true;
        }
        return false;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product getProduct(String name) {
        return productRepository.findByName(name).get();
    }

    @Override
    public Page<Product> getProductPage(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public boolean updateProduct(Product product) {
        Optional<Product> productOptional = productRepository.findById(product.getId());
        if(productOptional.isPresent())
        {
            Product productTemp = productOptional.get();
            productTemp.setImage(product.getImage());
            productTemp.setName(product.getName());
            productTemp.setPrice(product.getPrice());
            productRepository.save(productTemp);
            return true;
        }
        return false;
    }

    @Override
    public Page<Product> getProductPage(String partialName, Pageable pageable) {
        return productRepository.findByNameContaining(partialName, pageable);
    }
    
}
