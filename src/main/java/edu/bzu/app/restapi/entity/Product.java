package edu.bzu.app.restapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;




@Data

@AllArgsConstructor
@NoArgsConstructor

@Entity


public class Product {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;
    private String slug;
    private String name;
    private String reference;
    @Column
    private Long price;
    @Column
    private Long vat;

}


