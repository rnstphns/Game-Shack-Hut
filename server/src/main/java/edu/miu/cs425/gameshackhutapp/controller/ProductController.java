package edu.miu.cs425.gameshackhutapp.controller;

import edu.miu.cs425.gameshackhutapp.dto.ProductRequest;
import edu.miu.cs425.gameshackhutapp.model.Customer;
import edu.miu.cs425.gameshackhutapp.model.Product;
import edu.miu.cs425.gameshackhutapp.service.implementation.ProductService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/")
    public ResponseEntity<Product> addNewProduct(@Valid @RequestBody ProductRequest request){
        return new ResponseEntity<>(productService.newProduct(request), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Product>> getAll(@RequestParam Optional<String> search){
        if(search.isPresent()){
            var result = productService.getAllProductByFilter(search.get());
            return ResponseEntity.ok(result);
        }else{
            var result = productService.getAllProducts();
            return ResponseEntity.ok(result);
        }

    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getByID(@PathVariable Long id){
            var result = productService.getProductById(id);
            return ResponseEntity.ok(result);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@Valid @RequestBody ProductRequest request,@PathVariable Long id){
        var result = productService.editProduct(request,id);
        return ResponseEntity.ok(result);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        productService.deleteProductById(id);
        return ResponseEntity.ok("Success");
    }

}