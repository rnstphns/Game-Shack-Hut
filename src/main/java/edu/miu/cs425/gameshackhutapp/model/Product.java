package edu.miu.cs425.gameshackhutapp.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public interface Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    Long productId;
    @NotNull
    String productName;
    @NotNull
    Double price;
    Integer quantityInStock;

}
