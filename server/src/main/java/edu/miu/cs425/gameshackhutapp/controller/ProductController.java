package edu.miu.cs425.gameshackhutapp.controller;

import edu.miu.cs425.gameshackhutapp.model.Customer;
import edu.miu.cs425.gameshackhutapp.model.Product;
import edu.miu.cs425.gameshackhutapp.service.implementation.ProductService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
@CrossOrigin
@RequestMapping(value = "/test")
public class CheckoutController {

    @Autowired
    private ProductService service;

    @PostMapping("/new")
    public ResponseEntity<Product> addNewProduct(@Valid @RequestBody ProductRequest request){
        return new ResponseEntity<>(service.newProduct(request), HttpStatus.CREATED);
    }

    @PutMapping (value="/edit/{productId}"){
        public ResponseEntity<Product> editProduct(@Valid @RequestBody ProductRequest request,
                                                    @PathVariable Long productId){
            return new ResponseEntity<>(service.editProduct(request, productId), HttpStatus.OK);
        }
    }

    @Date
    static class ProductRequest{
        @NotNull
        private String productName;

        @NotNull
        private Double price;

        @NotBlank
        private Integer quantityInStock;

        @NotBlank
        private String type; //type of product, e.g. book, game, figure, etc.
    }
}