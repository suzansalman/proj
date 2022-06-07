package edu.bzu.app.restapi.controller;

import edu.bzu.app.restapi.dto.CustomerDto;
import edu.bzu.app.restapi.dto.Product_OrderDto;
import edu.bzu.app.restapi.exceptions.BadRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/e-commerce/customer")
public class Product_OrderController<Product_OrderServices> {
    private final Logger log = LoggerFactory.getLogger(Product_OrderController.class);

    private Product_OrderServices Product_OrderServices;

    public Product_OrderController(Product_OrderServices Product_OrderServices){
        this.Product_OrderServices=Product_OrderServices;
    }
    @GetMapping // get the information from the database
    public ResponseEntity<List<Product_OrderDto>> getAllProduct_Orders(){
        return ResponseEntity.ok().body(Product_OrderServices.getAllProduct_Orders());
    }
    @GetMapping("{id}")
    public ResponseEntity<Product_OrderDto> getProduct_OrderById(@PathVariable(name="id") int id){
        return ResponseEntity.ok().body(Product_OrderServices.getProduct_OrderById(id));
    }

    @PostMapping // creating data
    public ResponseEntity<Product_OrderDto> createProduct_Order(@Valid @RequestBody Product_OrderDto Product_OrderDto){
        if (Product_OrderDto.getId() != null){
            log.error("Cannot have an ID {}" , Product_OrderDto);
            throw new BadRequest("you cant send an id with the request");
        }
        return  new ResponseEntity(Product_OrderServices.createProduct_Order(Product_OrderDto), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Product_OrderDto> updateProduct_Order(@Valid @ RequestBody Product_OrderDto Product_OrderDto, @PathVariable(name="id") int id){
        CustomerController<Object> customerServices = null;
        @Valid CustomerDto customerDto = null;
        return new ResponseEntity(customerServices.updateCustomer(customerDto,id),HttpStatus.OK);
    }

    @DeleteMapping("{id}") // deleting data
    public ResponseEntity<String> deleteCustomer(@PathVariable(name="id") long id){
        CustomerServices.deleteCustomerById(id);
        return new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
    }
}
