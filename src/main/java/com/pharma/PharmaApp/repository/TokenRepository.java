package com.pharma.PharmaApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pharma.PharmaApp.models.Token;
import com.pharma.PharmaApp.models.User;

@Repository
public interface TokenRepository extends JpaRepository<Token, Integer> {

	Token findTokenByUser(User user);
	Token findTokenByToken(String token);
	
}
