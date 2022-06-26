package com.pharma.PharmaApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharma.PharmaApp.dto.cart.CartDTO;
import com.pharma.PharmaApp.dto.cart.ItemDTO;
import com.pharma.PharmaApp.dto.cart.TotalCartDTO;
import com.pharma.PharmaApp.exceptions.CustomException;
import com.pharma.PharmaApp.models.Cart;
import com.pharma.PharmaApp.models.Medication;
import com.pharma.PharmaApp.models.User;
import com.pharma.PharmaApp.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	CartRepository cartRepository;
	
    public void addToCart(Medication medication, User user, CartDTO cartDTO) {
        Cart cart = new Cart(medication, user, cartDTO.getQuantity());
        cartRepository.save(cart);
    }
    
    public TotalCartDTO listItems(User user) {
        List<Cart> list = cartRepository.findAllByUserOrderByDateDesc(user);
        List<ItemDTO> items = new ArrayList<>();
        
        for (Cart cart : list){
            ItemDTO itemDTO = new ItemDTO(cart);
            items.add(itemDTO);
        }

        double price = 0;
        
        for (ItemDTO itemDTO : items){
            price += itemDTO.getMedication().getPrice() * itemDTO.getQuantity();
        }

        return new TotalCartDTO(items, price);
    }
    
    public void deleteCartItem(int itemID, User user) throws CustomException {

        Optional<Cart> cart = cartRepository.findById(itemID);

        if (cart.isEmpty()) {
            throw new CustomException("Invalid Cart ID");
        }

        Cart cart_n = cart.get();

        if (cart_n.getUser() != user) {
            throw new CustomException("Invalid authentication");
        }

        cartRepository.deleteById(itemID);
    	
    }
	
}
