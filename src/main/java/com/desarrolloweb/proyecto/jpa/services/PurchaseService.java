package com.desarrolloweb.proyecto.jpa.services;

import java.util.Optional;

import com.desarrolloweb.proyecto.jpa.model.Purchase;
import com.desarrolloweb.proyecto.jpa.repository.PurchaseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService implements IPurchaseService{
    @Autowired
    private PurchaseRepository purchaseRepository;

    @Override
    public boolean addPurchase(Purchase purchase) {
        purchaseRepository.save(purchase);
        return true;
    }

    @Override
    public boolean deletePurchase(Purchase purchase) {
        Optional<Purchase> purchaseOptional = purchaseRepository.findById(purchase.getId());
        if(purchaseOptional.isPresent())
        {
            purchaseRepository.delete(purchaseOptional.get());
            return true;
        }
        return false;
    }

    @Override
    public boolean deletePurchase(Long id) {
        Optional<Purchase> purchaseOptional = purchaseRepository.findById(id);
        if(purchaseOptional.isPresent())
        {
            purchaseRepository.delete(purchaseOptional.get());
            return true;
        }
        return false;
    }

    @Override
    public boolean updatePurchase(Purchase purchase) {
        Optional<Purchase> purchaseOptional = purchaseRepository.findById(purchase.getId());
        if(purchaseOptional.isPresent())
        {
            Purchase purchaseTemp = purchaseOptional.get();
            purchaseTemp.setQuantity(purchase.getQuantity());
            purchaseRepository.save(purchaseTemp);
            return true;
        }
        return false;
    }
    
}
