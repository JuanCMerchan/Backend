package com.desarrolloweb.proyecto.jpa.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.desarrolloweb.proyecto.jpa.model.Invoice;
import com.desarrolloweb.proyecto.jpa.repository.InvoiceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService implements IInvoiceService{
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public boolean addInvoice(Invoice invoice) {
        invoiceRepository.save(invoice);
        return true;
    }

    @Override
    public boolean deleteInvoice(Invoice invoice) {
        Optional<Invoice> invoiceOptional = invoiceRepository.findById(invoice.getId());
        if(invoiceOptional.isPresent())
        {
            invoiceRepository.delete(invoiceOptional.get());
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteInvoice(Long id) {
        Optional<Invoice> invoiceOptional = invoiceRepository.findById(id);
        if(invoiceOptional.isPresent())
        {
            invoiceRepository.delete(invoiceOptional.get());
            return true;
        }
        return false;
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    @Override
    public Page<Invoice> getInvoicePage(Pageable pageable) {
        return invoiceRepository.findAll(pageable);
    }

    @Override
    public Page<Invoice> getInvoicePage(Date date1, Date date2, Pageable pageable) {
        return invoiceRepository.findByDateBetween(date1, date2, pageable);
    }

    @Override
    public Page<Invoice> getInvoicePage(Long userId, Pageable pageable) {
        return invoiceRepository.findByUserId(userId, pageable);
    }

    @Override
    public Page<Invoice> getInvoicePage(Long userId, Date date1, Date date2, Pageable pageable) {
        return invoiceRepository.findByUserIdAndDateBetween(userId, date1, date2, pageable);
    }
    
}
