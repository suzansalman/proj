package edu.bzu.app.restapi.service;

import edu.bzu.app.restapi.dto.OrderDto;

import java.util.List;

public interface OrderService {
    OrderDto createOrder(OrderDto OrderDto);

    List<OrderDto> getAllOrders();

    OrderDto getOrderById(int id);

    OrderDto updateOrder( OrderDto OrderDto, int id);

    void deleteOrderById(int id);
}
