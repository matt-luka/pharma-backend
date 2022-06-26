package com.pharma.PharmaApp.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharma.PharmaApp.exceptions.TokenFailureException;
import com.pharma.PharmaApp.models.Token;
import com.pharma.PharmaApp.models.User;
import com.pharma.PharmaApp.repository.TokenRepository;

@Service
public class TokenService {

	@Autowired
	TokenRepository tokenRepository;
	
	public Token getToken(User user) {
		return tokenRepository.findTokenByUser(user);
	}
	
	public void setToken(Token token) {
		tokenRepository.save(token);
	}
	
	public User getUser(String token) {
		Token t_token = tokenRepository.findTokenByToken(token);
		
		if (Objects.nonNull(t_token) && Objects.nonNull(t_token.getUser())) {
			return t_token.getUser();
		}
		else {
			return null;
		}
		
	}
	
	public void auth(String token) throws TokenFailureException {
		
		if (Objects.isNull(token)) {
			throw new TokenFailureException("Token does not exist");
		}
		else if(Objects.isNull(this.getUser(token))) {
			throw new TokenFailureException("Invalid token");
		}
		
	}
	
}
