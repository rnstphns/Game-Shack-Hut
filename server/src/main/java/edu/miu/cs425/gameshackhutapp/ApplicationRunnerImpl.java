package edu.miu.cs425.gameshackhutapp;

import com.github.javafaker.Faker;
import edu.miu.cs425.gameshackhutapp.model.Checkout;
import edu.miu.cs425.gameshackhutapp.model.Customer;
import edu.miu.cs425.gameshackhutapp.model.Event;
import edu.miu.cs425.gameshackhutapp.model.Product;
import edu.miu.cs425.gameshackhutapp.repository.CheckoutRepository;
import edu.miu.cs425.gameshackhutapp.repository.CustomerRepository;
import edu.miu.cs425.gameshackhutapp.repository.EventRepository;
import edu.miu.cs425.gameshackhutapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class ApplicationRunnerImpl implements ApplicationRunner {

    private final Faker faker = new Faker();
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private CheckoutRepository checkoutRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        checkoutRepository.deleteAll();
        eventRepository.deleteAll();
        productRepository.deleteAll();
        customerRepository.deleteAll();

         generateCustomers();
         generateProducts();
         generateEvents();
         generateCheckouts();
    }


    private void generateCustomers(){
        for (int i = 0; i < 30; i++) {
            Customer customer = new Customer();
            customer.setName(faker.name().fullName());
            customer.setEmail(faker.internet().emailAddress());
            customerRepository.save(customer);
        }
    }

    private void generateProducts(){
        for (int i = 0; i < 15; i++) {
            Product product = new Product();
            product.setQuantityInStock(faker.random().nextInt(1, 10));
            product.setProductName(faker.esports().game());
            product.setPrice(Double.valueOf(faker.random().nextInt(10, 10_000)));
            product.setType(faker.book().genre());
            productRepository.save(product);
        }
    }

    private void generateEvents(){
        for (int i = 0; i < 15; i++) {
            Event event = new Event();
            event.setEventName(faker.esports().event());
            event.setCapacity(faker.random().nextInt(1, 15));
            event.setDate(faker.date().future(10, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            eventRepository.save(event);
        }
    }

    private void generateCheckouts(){
        List<Customer> customers = customerRepository.findAll();
        List<Product> products = productRepository.findAll();

        for (int i = 0; i < 50; i++) {
            Checkout checkout = new Checkout();
            checkout.setCheckoutDate(faker.date().future(10, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            checkout.setCustomer(customers.get(faker.random().nextInt(0, customers.size() - 1)));
            checkout.setProduct(products.get(faker.random().nextInt(0, products.size() - 1)));
            checkoutRepository.save(checkout);
        }
    }
}
