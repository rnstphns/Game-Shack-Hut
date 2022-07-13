package edu.miu.cs425.gameshackhutapp.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    Long productId;
    @NotNull
    String productName;
    @NotNull
    Double price;
    Integer quantityInStock;

    @OneToOne(mappedBy = "product")
    private Checkout checkout;

}
