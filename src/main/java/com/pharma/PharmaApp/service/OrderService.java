package com.pharma.PharmaApp.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharma.PharmaApp.dto.cart.CartDTO;
import com.pharma.PharmaApp.dto.cart.ItemDTO;
import com.pharma.PharmaApp.dto.cart.TotalCartDTO;
import com.pharma.PharmaApp.exceptions.CustomException;
import com.pharma.PharmaApp.models.Order;
import com.pharma.PharmaApp.models.OrderItem;
import com.pharma.PharmaApp.models.User;
import com.pharma.PharmaApp.repository.OrderItemRepository;
import com.pharma.PharmaApp.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	CartService cartService;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderItemRepository itemRepository;
	
    public void placeOrder(User user) {
        TotalCartDTO cartDTO = cartService.listItems(user);
        List<ItemDTO> itemDTOList = cartDTO.getItems();

        Order order = new Order();
        order.setPrice(cartDTO.getPrice());
        order.setUser(user);
        order.setDate(new Date());
        orderRepository.save(order);

        for (ItemDTO cartItemDto : itemDTOList) {
            OrderItem item = new OrderItem();
            item.setOrder(order);
            item.setMedication(cartItemDto.getMedication());
            item.setDate(new Date());
            item.setQuantity(cartItemDto.getQuantity());
            item.setPrice(cartItemDto.getMedication().getPrice());
            itemRepository.save(item);
        }
    }
    
    public List<Order> listOrders(User user) {
        return orderRepository.findAllByUserOrderByDateDesc(user);
    }
    
    public Order getOrder(Integer orderId, User user) throws CustomException {
    	Optional<Order> order = orderRepository.findById(orderId);

        if (order.isEmpty()) {
            throw  new CustomException("Invalid ID");
        }

        Order order_n = order.get();

        if(order_n.getUser() != user) {
            throw  new CustomException("Invalid authentication");
        }

        return order_n;
    }

}
