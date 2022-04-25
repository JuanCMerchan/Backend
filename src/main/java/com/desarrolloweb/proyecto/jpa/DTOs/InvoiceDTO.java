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
}
