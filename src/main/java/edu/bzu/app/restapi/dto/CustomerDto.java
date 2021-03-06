package edu.bzu.app.restapi.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data

public class CustomerDto {
    private Integer id;

    @NotNull
    @Size(min = 3, max = 250)
    private String firstName;
    private String lastName;
    private Date bornAt;
}
