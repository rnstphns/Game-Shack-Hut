package edu.miu.cs425.gameshackhutapp.repository;

import edu.miu.cs425.gameshackhutapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByProductNameLike(String search);
}
