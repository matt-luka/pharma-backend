package com.pharma.PharmaApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pharma.PharmaApp.config.APIResponse;
import com.pharma.PharmaApp.exceptions.CustomException;
import com.pharma.PharmaApp.exceptions.TokenFailureException;
import com.pharma.PharmaApp.models.Order;
import com.pharma.PharmaApp.models.User;
import com.pharma.PharmaApp.service.OrderService;
import com.pharma.PharmaApp.service.TokenService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private TokenService tokenService;
	
    @GetMapping("/")
    public ResponseEntity<List<Order>> getAllOrders(@RequestParam("token") String token) throws TokenFailureException {
        tokenService.auth(token);
        User user = tokenService.getUser(token);
        List<Order> DTO = orderService.listOrders(user);
        
        return new ResponseEntity<>(DTO, HttpStatus.OK);
    }
	
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOrderById(@PathVariable("id") Integer id, @RequestParam("token") String token) throws TokenFailureException, CustomException {
        tokenService.auth(token);
        User user = tokenService.getUser(token);
        Order order = orderService.getOrder(id, user);

        return new ResponseEntity<>(order, HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<APIResponse> placeOrder(@RequestParam("token") String token) throws TokenFailureException {
        tokenService.auth(token);
        User user = tokenService.getUser(token);
        orderService.placeOrder(user);
        
        return new ResponseEntity<>(new APIResponse(true, "Successfully created order"), HttpStatus.CREATED);
    }
    
}
