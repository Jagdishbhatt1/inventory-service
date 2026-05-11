package com.inventory.inventory.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {

    private Long id;
    private String name;
    private double price;
    private int stockQuantity;
    private String description;
}
