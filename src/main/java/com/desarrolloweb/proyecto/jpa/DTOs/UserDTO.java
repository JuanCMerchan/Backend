package com.desarrolloweb.proyecto.jpa.DTOs;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    private long id;
    private String name;
    private String email;
    private boolean isAdmin;
    private List<PurchaseDTO> shoppingCart;


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isIsAdmin() {
        return this.isAdmin;
    }

    public boolean getIsAdmin() {
        return this.isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public List<PurchaseDTO> getShoppingCart() {
        return this.shoppingCart;
    }

    public void setShoppingCart(List<PurchaseDTO> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

}
