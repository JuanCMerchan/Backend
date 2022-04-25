package com.desarrolloweb.proyecto.jpa.DTOs;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class InvoiceDTO {
    private long id;
    private long userId;
    private List<PurchaseDTO> listPurchases;
    private int priceTotal;
    private Date date;


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public List<PurchaseDTO> getListPurchases() {
        return this.listPurchases;
    }

    public void setListPurchases(List<PurchaseDTO> listPurchases) {
        this.listPurchases = listPurchases;
    }

    public int getPriceTotal() {
        return this.priceTotal;
    }

    public void setPriceTotal(int priceTotal) {
        this.priceTotal = priceTotal;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
