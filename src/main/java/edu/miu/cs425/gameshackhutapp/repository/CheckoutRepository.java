package edu.miu.cs425.gameshackhutapp.repository;

import edu.miu.cs425.gameshackhutapp.model.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckoutRepository extends JpaRepository<Checkout, Long> {
}
