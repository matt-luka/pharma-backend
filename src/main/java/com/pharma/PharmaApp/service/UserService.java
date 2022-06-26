package com.pharma.PharmaApp.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharma.PharmaApp.dto.user.RegisterDTO;
import com.pharma.PharmaApp.dto.user.ResponseDTO;
import com.pharma.PharmaApp.exceptions.CustomException;
import com.pharma.PharmaApp.models.Token;
import com.pharma.PharmaApp.models.User;
import com.pharma.PharmaApp.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TokenService tokenService;
	
    public ResponseDTO register(RegisterDTO regDTO) throws CustomException {
        if (Objects.nonNull(userRepository.findByEmail(regDTO.getEmail()))) {
            throw new CustomException("Cannot register: Duplicate user");
        }
        String safePass = regDTO.getPassword();
        try {
            safePass = hashPassword(regDTO.getPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        User user = new User(regDTO.getFirstName(), regDTO.getLastName(), regDTO.getEmail(), regDTO.getPhone(), regDTO.getZip(), safePass);
        
        try {
             userRepository.save(user);
             final Token token = new Token(user);
             tokenService.setToken(token);
             
            return new ResponseDTO("201", "Succesfully created user");
        } catch (Exception e) {
            throw new CustomException(e.getMessage());
        }
    }
    
    String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest sha = MessageDigest.getInstance("MD5");
        sha.update(password.getBytes());
        byte[] digest = sha.digest();
        String hashed_password = DatatypeConverter.printHexBinary(digest).toUpperCase();
        return hashed_password;
    }
	
}
