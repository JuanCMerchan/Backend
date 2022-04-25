package com.desarrolloweb.proyecto.jpa.repository;

import java.util.List;
import java.util.Optional;

import com.desarrolloweb.proyecto.jpa.model.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>{
    Optional<Product> findById(Long Id);
    
    Optional<Product> findByName(String name);

    List<Product> findByNameContaining(String partialName);

    Page<Product> findByNameContaining(String partialName, Pageable pageable);

    List<Product> findByPriceBetween(Integer price1, Integer price2);
}
