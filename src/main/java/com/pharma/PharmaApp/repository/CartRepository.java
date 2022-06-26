package com.pharma.PharmaApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pharma.PharmaApp.models.Cart;
import com.pharma.PharmaApp.models.User;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    List<Cart> findAllByUserOrderByDateDesc(User user);
	
}
