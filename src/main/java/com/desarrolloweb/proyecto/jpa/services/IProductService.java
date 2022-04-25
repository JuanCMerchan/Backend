package com.desarrolloweb.proyecto.jpa.services;

import java.util.List;

import com.desarrolloweb.proyecto.jpa.model.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    public boolean addProduct(Product product);

    public boolean updateProduct(Product product);

    public boolean deleteProduct(Product product);

    public boolean deleteProduct(Long id);

    public Product getProduct(Long id);

    public Product getProduct(String name);

    public Page<Product> getProductPage(Pageable pageable);

    public Page<Product> getProductPage(String partialName, Pageable pageable);

    public List<Product> getAllProducts();
}
