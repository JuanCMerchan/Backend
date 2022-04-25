package com.desarrolloweb.proyecto.jpa.repository;

import java.util.Optional;

import com.desarrolloweb.proyecto.jpa.model.Purchase;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long>
{
    Optional<Purchase> findById(Long Id);
}
