package com.desarrolloweb.proyecto.jpa.services;

import com.desarrolloweb.proyecto.jpa.model.Purchase;

public interface IPurchaseService {
    public boolean addPurchase(Purchase purchase);

    public boolean deletePurchase(Purchase purchase);

    public boolean deletePurchase(Long id);

    public boolean updatePurchase(Purchase purchase);
}
