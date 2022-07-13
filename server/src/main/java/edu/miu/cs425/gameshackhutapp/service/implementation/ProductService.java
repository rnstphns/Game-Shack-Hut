package edu.miu.cs425.gameshackhutapp.service.implementation;

import edu.miu.cs425.gameshackhutapp.model.Checkout;
import edu.miu.cs425.gameshackhutapp.model.Customer;
import edu.miu.cs425.gameshackhutapp.model.Product;
import edu.miu.cs425.gameshackhutapp.repository.CheckoutRepository;
import edu.miu.cs425.gameshackhutapp.repository.CustomerRepository;
import edu.miu.cs425.gameshackhutapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class ProductService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CheckoutRepository checkoutRepository;

    public void newProduct(ProductRequest request){
        var newProduct = new Product(null, request.getProductName(), request.getPrice(),
                request.getQuantityInStock(), request.getType());
        return productRepository.save(newProduct);
    }

    public void deleteProductById(Long productId){
        productRepository.deleteById(productId);
    }

    public Product editProduct(ProductRequest request, Long productId){
        var newProduct = new Product(productId, request.getProductName(), request.getPrice(),
                request.getQuantityInStock(), request.getType());
        return productRepository.save(newProduct);
    }
    public Product getProductById(Long productId){
        return productRepository.findById(productId);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public void checkout(Long productId, Long customerId) {
        Product product = productRepository.findById(productId).orElse(null);
        Customer customer = customerRepository.findById(customerId).orElse(null);

        if(product == null || customer == null){
            throw new RuntimeException("product or customer not found");
        }

        if(!isProductInStock(product)){
            throw new RuntimeException("product out of stock");
        }

        Checkout checkout = new Checkout();
        checkout.setCheckoutDate(LocalDate.now());
        checkout.setProduct(product);
        checkout.setCustomer(customer);

        checkoutRepository.save(checkout);

        product.setQuantityInStock(product.getQuantityInStock() - 1);
        productRepository.save(product);

        // maybe return a checkout dto
    }

    private boolean isProductInStock(Product product){
        return product.getQuantityInStock() > 0;
    }
}
