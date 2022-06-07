package edu.bzu.app.restapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;




@Data

@AllArgsConstructor
@NoArgsConstructor

@Entity


public class Product_Order {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int productid;
    private int Orderid;
    private int quantity;
    @Column
    private Long price;
    @Column
    private Long vat;


}



