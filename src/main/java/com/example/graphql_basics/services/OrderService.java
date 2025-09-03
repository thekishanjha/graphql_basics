package com.example.graphql_basics.services;

import com.example.graphql_basics.entities.Order;
import com.example.graphql_basics.helper.ExceptionHelper;
import com.example.graphql_basics.repositories.OrderRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private OrderRepo orderRepo;

    public OrderService(OrderRepo orderRepo){
        this.orderRepo = orderRepo;
    }

    //create order
    public Order createOrder(Order order){
        return orderRepo.save(order);
    }

    //get all order
    public List<Order> getAllOrder(){
        return orderRepo.findAll();
    }

    //get single order
    public Order getOrder(int orderId){
        Order order1 = orderRepo.findById(orderId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
        return order1;
    }

    //delete order
    public boolean deleteOrder(int orderId){
        Order order1 = orderRepo.findById(orderId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
        orderRepo.delete(order1);
        return true;
    }
}
