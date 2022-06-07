package edu.bzu.app.restapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/e-commerce/customer")
public class ProductController {
    private final Logger log = LoggerFactory.getLogger(ProductController.class);

    private CustomerServices customerServices;

    public ProductController(CustomerServices customerServices){
        this.customerServices=customerServices;
    }
    @GetMapping // get the information from the database
    public ResponseEntity<List<CustomerDto>> getAllCustomers(){
        return ResponseEntity.ok().body(customerServices.getAllCustomers());
    }
    @GetMapping("{id}") // to specify that there will be an id after the path
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable(name="id") long id){
        return ResponseEntity.ok().body(customerServices.getCustomerById(id));
    }

    @PostMapping // creating data
    public ResponseEntity<CustomerDto> createCustomer(@Valid @RequestBody CustomerDto customerDto){
        if (customerDto.getId() != null){
            log.error("Cannot have an ID {}" , customerDto);
            throw new BadRequest("you cant send an id with the request");
        }
        return  new ResponseEntity(customerServices.createCustomer(customerDto), HttpStatus.CREATED);
    }

    @PutMapping("{id}") // updating data
    public ResponseEntity<CustomerDto> updateCustomer(@Valid @ RequestBody CustomerDto customerDto, @PathVariable(name="id") long id){
        return new ResponseEntity(customerServices.updateCustomer(customerDto,id),HttpStatus.OK);
    }

    @DeleteMapping("{id}") // deleting data
    public ResponseEntity<String> deleteCustomer(@PathVariable(name="id") long id){
        customerServices.deleteCustomerById(id);
        return new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
    }
}
