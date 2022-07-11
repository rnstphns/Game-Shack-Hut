package edu.miu.cs425.gameshackhutapp.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="checkout-record")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    @NotNull
    @Transient  //TODO is this correct?
    private List<OrderLine> cart;
    @NotNull
    private Customer customer;
}
