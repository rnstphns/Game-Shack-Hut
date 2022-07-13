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

    @PostMapping("/checkout")
    public ResponseEntity<?> performCheckout(@RequestBody CheckoutRequestDto request){
        service.checkout(request.productId, request.customerId);
        return ResponseEntity.ok().build();
    }

    @Data
    static class CheckoutRequestDto{
        private Long productId;
        private Long customerId;
    }
}
