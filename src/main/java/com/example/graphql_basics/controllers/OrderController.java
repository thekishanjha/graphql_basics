package com.example.graphql_basics.controllers;

import com.example.graphql_basics.entities.Order;
import com.example.graphql_basics.entities.User;
import com.example.graphql_basics.services.OrderService;
import com.example.graphql_basics.services.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class OrderController {

    private UserService userService;
    private OrderService orderService;

    public OrderController(UserService userService, OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }

    //create order
    @MutationMapping
    public Order createOrder(
            @Argument String orderDetail,
            @Argument String address,
            @Argument int price,
            @Argument int userId)
    {
        User user = userService.getUserById(userId);
        Order order = new Order();
        order.setOrderDetail(orderDetail);
        order.setAddress(address);
        order.setPrice(price);
        order.setUser(user);

        return orderService.createOrder(order);

    }

    //get all Orders
    @QueryMapping
    public List<Order> getOrders(){
        return orderService.getAllOrder();
    }

    //delete order
    @MutationMapping
    public boolean deleteOrder(int orderId){
        return orderService.deleteOrder(orderId);
    }

}
