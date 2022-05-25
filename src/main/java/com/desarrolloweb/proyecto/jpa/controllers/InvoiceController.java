package com.desarrolloweb.proyecto.jpa.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.desarrolloweb.proyecto.jpa.DTOs.InvoiceDTO;
import com.desarrolloweb.proyecto.jpa.DTOs.PurchaseDTO;
import com.desarrolloweb.proyecto.jpa.model.Invoice;
import com.desarrolloweb.proyecto.jpa.model.Purchase;
import com.desarrolloweb.proyecto.jpa.model.User;
import com.desarrolloweb.proyecto.jpa.services.IInvoiceService;
import com.desarrolloweb.proyecto.jpa.services.IUserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.solr.core.query.SolrPageRequest;

@RestController
@RequestMapping("invoice")
public class InvoiceController {
    @Autowired
    private IInvoiceService invoiceService;

    @Autowired
    private IUserService userService;

    @GetMapping("/page/{page}/{size}")
    public Page<InvoiceDTO> getInvoices(@PathVariable("page") int page, @PathVariable("size") int size)
    {
        Pageable pageable = new SolrPageRequest(page, size, Sort.by(Direction.ASC, "id"));
        Page<Invoice> Invoices = invoiceService.getInvoicePage(pageable);
        List<InvoiceDTO> result = convertDTOs(Invoices);
        return new PageImpl<>(result, pageable, Invoices.getTotalElements());
    }

    @GetMapping("/page/{page}/{size}/{startDate}/{endDate}")
    public Page<InvoiceDTO> getInvoices(@PathVariable("page") int page, @PathVariable("size") int size,@PathVariable("startDate") String startDate,@PathVariable("endDate") String endDate)
    {
        Pageable pageable = new SolrPageRequest(page, size, Sort.by(Direction.ASC, "id"));
        Page<Invoice> Invoices = invoiceService.getInvoicePage(parseDate(startDate), parseDate(endDate), pageable);
        List<InvoiceDTO> result = convertDTOs(Invoices);
        return new PageImpl<>(result, pageable, Invoices.getTotalElements());
    }

    @GetMapping("/list/{username}")
    public List<InvoiceDTO> getInvoices(@PathVariable("username") String username)
    {
        User user = userService.getUserByUsername(username);
        List<Invoice> Invoices = invoiceService.getInvoiceList(user.getId());
        List<InvoiceDTO> result = convertDTOs(Invoices);
        return result;
    }

    @GetMapping("/page/{page}/{size}/{username}")
    public List<InvoiceDTO> getInvoices(@PathVariable("page") int page, @PathVariable("size") int size, @PathVariable("username") String username)
    {
        User user = userService.getUserByUsername(username);
        Pageable pageable = new SolrPageRequest(page, size, Sort.by(Direction.ASC, "id"));
        Page<Invoice> Invoices = invoiceService.getInvoicePage(user.getId(), pageable);
        List<InvoiceDTO> result = convertDTOs(Invoices);
        return result;
    }

    @GetMapping("/list/{startDate}/{endDate}/{username}")
    public List<InvoiceDTO> getInvoices(@PathVariable("startDate") String startDate,@PathVariable("endDate") String endDate, @PathVariable("username") String username)
    {
        User user = userService.getUserByUsername(username);
        List<Invoice> Invoices = invoiceService.getInvoiceList(user.getId(), parseDate(startDate), parseDate(endDate));
        List<InvoiceDTO> result = convertDTOs(Invoices);
        return result;
    }

    @GetMapping("/list/{startDate}/{endDate}")
    public List<InvoiceDTO> getInvoices(@PathVariable("startDate") String startDate,@PathVariable("endDate") String endDate)
    {
        List<Invoice> Invoices = invoiceService.getInvoiceList(parseDate(startDate), parseDate(endDate));
        List<InvoiceDTO> result = convertDTOs(Invoices);
        return result;
    }

    @PostMapping("/create/{username}")
    public boolean createInvoice(@RequestBody Invoice newInvoice, @PathVariable("username") String username)
    {
        newInvoice.setDate(new Date());
        User user = userService.getUserByUsername(username);
        newInvoice.setUserId(user.getId());
        return invoiceService.addInvoice(newInvoice);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteInvoice(@PathVariable("id") long id)
    {
        return invoiceService.deleteInvoice(id);
    }

    private InvoiceDTO convertDTO(Invoice invoice)
    {
        ModelMapper mapper = new ModelMapper();
        InvoiceDTO result = mapper.map(invoice, InvoiceDTO.class);
        result.setListPurchases(new ArrayList<>());
        for(Purchase purchase : invoice.getListPurchases())
        {
            result.getListPurchases().add(mapper.map(purchase, PurchaseDTO.class));
        }
        return result;
    }

    private List<InvoiceDTO> convertDTOs(Page<Invoice> invoices)
    {
        List<InvoiceDTO> result = new ArrayList<>();
        for(Invoice invoice : invoices)
        {
            result.add(convertDTO(invoice));
        }
        return result;
    } 

    private List<InvoiceDTO> convertDTOs(List<Invoice> invoices)
    {
        List<InvoiceDTO> result = new ArrayList<>();
        for(Invoice invoice : invoices)
        {
            result.add(convertDTO(invoice));
        }
        return result;
    } 
    
    private Date parseDate(String dateString) {
		try 
        {
			DateFormat date = new SimpleDateFormat("dd-MM-yyyy");
			return date.parse(dateString);
		} 
        catch (ParseException e) 
        {
            return null;
		}
	}
}
