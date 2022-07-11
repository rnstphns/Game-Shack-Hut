package edu.miu.cs425.gameshackhutapp.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="products")
public class Collectable implements Product{

    private String type;

}
