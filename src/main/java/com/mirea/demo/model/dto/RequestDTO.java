package com.mirea.demo.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestDTO {
    private Long id;
    private String name;
    private String description;
    private Double amount;
}
