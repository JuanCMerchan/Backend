package com.desarrolloweb.proyecto.jpa.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PurchaseDTO {
    long id;
    private long productId;
    private int quantity;
}
