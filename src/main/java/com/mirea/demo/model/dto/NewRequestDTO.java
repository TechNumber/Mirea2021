package com.mirea.demo.model.dto;

import lombok.Data;

@Data
public class NewRequestDTO {
    private String name;
    private String description;
    private Double amount;
}
