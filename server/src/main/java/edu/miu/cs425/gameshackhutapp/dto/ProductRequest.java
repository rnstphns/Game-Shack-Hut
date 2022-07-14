package edu.miu.cs425.gameshackhutapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest{
    @NotNull
    private String productName;

    @NotNull
    private Double price;

    @NotBlank
    private Integer quantityInStock;

    @NotBlank
    private String type; //type of product, e.g. book, game, figure, etc.
}