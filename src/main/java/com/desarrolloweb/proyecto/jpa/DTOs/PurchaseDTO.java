package com.desarrolloweb.proyecto.jpa.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PurchaseDTO {
    long id;
    private ProductDTO product;
    private int quantity;


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ProductDTO getProduct() {
        return this.product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
