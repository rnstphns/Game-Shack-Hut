package edu.miu.cs425.gameshackhutapp.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @NotNull
    private String name;
    @Email
    private String email;

    @OneToMany(mappedBy = "customer")
    private List<Checkout> checkoutList;

}
