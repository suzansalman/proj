package edu.bzu.app.restapi.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Data

@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table
public class Customer implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
   private  Date bornAtDate;

}
