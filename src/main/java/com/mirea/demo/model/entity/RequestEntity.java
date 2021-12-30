package com.mirea.demo.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "request")
@Data
public class RequestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "request_id_generator")
    @SequenceGenerator(name = "request_id_generator", sequenceName = "request_id_seq", allocationSize = 1)
    private Long id;
    private String name;
    private String description;
    private Double amount;
}