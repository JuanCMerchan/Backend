package com.desarrolloweb.proyecto.jpa.controllers;

import javax.websocket.server.PathParam;

import com.desarrolloweb.proyecto.jpa.model.Purchase;
import com.desarrolloweb.proyecto.jpa.services.IPurchaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("purchase")
public class PurchaseController {
    @Autowired
    IPurchaseService purchaseService;

    @PostMapping("/create")
    public boolean createPurchase(@RequestBody Purchase newPurchase)
    {
        return purchaseService.addPurchase(newPurchase);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deletePurchase(@PathParam("id") long id)
    {
        return purchaseService.deletePurchase(id);
    }

    @PutMapping("/update")
    public boolean updatePurchase(@RequestBody Purchase purchase)
    {
        return purchaseService.updatePurchase(purchase);
    }
}
