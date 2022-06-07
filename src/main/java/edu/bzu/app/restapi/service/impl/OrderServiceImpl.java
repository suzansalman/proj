package edu.bzu.app.restapi.service.impl;


import edu.bzu.app.restapi.dto.OrderDto;
import edu.bzu.app.restapi.entity.Product;
import edu.bzu.app.restapi.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class OrderServiceImpl implements OrderService {

    private edu.bzu.app.restapi.repository.OrderRepository OrderRepository;

    public OrderServiceImpl(OrderRepository OrderRepository) {
        this.OrderRepository = OrderRepository;
    }

    @Override
    public OrderDto createOrder(OrderDto OrderDto) {

        Product Order = mapToEntity(OrderDto);
        Product newOrder = OrderRepository.save(Order);


        OrderDto OrderResponse = mapToDTO(newOrder);
        return OrderResponse;
    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<Product> Orders = OrderRepository.findAll();
        return Orders.stream().map(Order -> mapToDTO(Order)).collect(Collectors.toList());
    }

    @Override
    public OrderDto getOrderById(int id) {
        Product Order = OrderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order", "id", id));
        return mapToDTO(Order);
    }

    @Override
    public OrderDto updateOrder(OrderDto OrderDto, int id) {

        Product Order = OrderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order", "id", id));


        Product updatedOrder= OrderRepository.save(Order);
        return mapToDTO(updatedOrder);
    }

    @Override
    public void deleteOrderById(int id) {

        Product Order = OrderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order", "id", id));
        OrderRepository.delete(Order);
    }


    private OrderDto mapToDTO(Product Order){
        OrderDto OrderDto = new OrderDto();
        OrderDto.setId(Order.getId());


        return OrderDto;
    }


    private Product mapToEntity(OrderDto OrderDto){
        Product Order = new Product();
        OrderDto.setId(Order.getId());
        return Order;
    }
}
