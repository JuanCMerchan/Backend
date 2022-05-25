package com.desarrolloweb.proyecto.jpa.services;

import java.util.Date;
import java.util.List;

import com.desarrolloweb.proyecto.jpa.model.Invoice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IInvoiceService {
    public boolean addInvoice(Invoice invoice);

    public boolean deleteInvoice(Invoice invoice);

    public boolean deleteInvoice(Long id);

    public List<Invoice> getAllInvoices();

    public List<Invoice> getInvoiceList(Long userId);

    public List<Invoice> getInvoiceList(Date date1, Date date2);

    public List<Invoice> getInvoiceList(Long userId, Date date1, Date date2);

    public Page<Invoice> getInvoicePage(Pageable pageable);

    public Page<Invoice> getInvoicePage(Date date1, Date date2, Pageable pageable);

    public Page<Invoice> getInvoicePage(Long userId, Pageable pageable);

    public Page<Invoice> getInvoicePage(Long userId, Date date1, Date date2, Pageable pageable);
}
