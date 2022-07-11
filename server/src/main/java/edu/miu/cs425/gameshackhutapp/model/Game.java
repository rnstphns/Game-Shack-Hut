package edu.miu.cs425.gameshackhutapp.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="products")
public class Game implements Product{

    private String manufacturer;
    private String genre;
}
