package com.pharma.PharmaApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pharma.PharmaApp.models.Order;
import com.pharma.PharmaApp.models.User;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

	List<Order> findAllByUserOrderByDateDesc(User user);
	
}
