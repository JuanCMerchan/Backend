package com.desarrolloweb.proyecto.jpa.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.desarrolloweb.proyecto.jpa.model.Invoice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long>
{
    Optional<Invoice> findById(Long id);    

    List<Invoice>  findByUserId(Long userId);

    Page<Invoice> findByUserId(Long userId, Pageable pageable);

    List<Invoice> findByDateBetween(Date date1, Date date2);

    Page<Invoice> findByDateBetween(Date date1, Date date2, Pageable pageable);

    List<Invoice> findByUserIdAndDateBetween(Long userId, Date date1, Date date2);

    Page<Invoice> findByUserIdAndDateBetween(Long userId, Date date1, Date date2, Pageable pageable);
}
