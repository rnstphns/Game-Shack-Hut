package edu.miu.cs425.gameshackhutapp.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "customer_checkouts")
public class Checkout {

    @Id
    @GeneratedValue
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private LocalDate checkoutDate;
}
