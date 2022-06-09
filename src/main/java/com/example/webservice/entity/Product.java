package com.example.webservice.entity;


import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Product {
    private Integer id;
    private String name;
    private double price;
}
