package com.desarrolloweb.proyecto.jpa.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ProductDTO {
    private long id;
    private String name;
    private int price;
    private byte[] image;
}
