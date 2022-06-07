package edu.bzu.app.restapi.controller;

import edu.bzu.app.restapi.dto.OrderDto;
import edu.bzu.app.restapi.exceptions.BadRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/e-commerce/Order")
public class OrderController {
    private final Logger log = LoggerFactory.getLogger(OrderController.class);

    private OrderServices OrderServices;

    public OrderController(OrderServices OrderServices){
        this.OrderServices=OrderServices;
    }
    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders(){
        return ResponseEntity.ok().body(OrderServices.getAllOrders());
    }
    @GetMapping("{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable(name="id") int id){
        return ResponseEntity.ok().body(OrderServices.getOrderById(id));
    }

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@Valid @RequestBody OrderDto OrderDto){
        if (OrderDto.getId() != null){
            log.error("Cannot have an ID {}" , OrderDto);
            throw new BadRequest("you cant send an id with the request");
        }
        return  new ResponseEntity(OrderServices.createOrder(OrderDto), HttpStatus.CREATED);
    }

    @PutMapping("{id}") // updating data
    public ResponseEntity<OrderDto> updateOrder(@Valid @ RequestBody OrderDto OrderDto, @PathVariable(name="id") int id){
        return new ResponseEntity(OrderServices.updateOrder(OrderDto,id),HttpStatus.OK);
    }

    @DeleteMapping("{id}") // deleting data
    public ResponseEntity<String> deleteOrder(@PathVariable(name="id") int id){
        OrderServices.deleteOrderById(id);
        return new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
    }
}
