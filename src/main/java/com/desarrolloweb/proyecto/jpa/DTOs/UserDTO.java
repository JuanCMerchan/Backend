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
    private String username;
    private List<PurchaseDTO> shoppingCart;
    private boolean isAdmin;
}
