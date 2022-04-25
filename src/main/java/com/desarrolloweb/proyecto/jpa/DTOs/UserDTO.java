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
}
