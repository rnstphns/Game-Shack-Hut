package edu.miu.cs425.gameshackhutapp.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long productId;

    @NotNull
    private String productName;

    @NotNull
    private Double price;

    @NotBlank
    private Integer quantityInStock;

    @NotBlank
    private String type; //type of product, e.g. book, game, figure, etc.
                        //could be Enum for consistency, unless that complicates database retrieval



}
