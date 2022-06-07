package edu.bzu.app.restapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;



@Data

@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(
        name = "category_tbl", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})}
)


public class Order {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;
    private int customerid;
    private Date orderAtDate;}


