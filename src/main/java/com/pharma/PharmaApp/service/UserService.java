package com.pharma.PharmaApp.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.pharma.PharmaApp.dto.user.RegisterDTO;
import com.pharma.PharmaApp.dto.user.ResponseDTO;
import com.pharma.PharmaApp.exceptions.CustomException;
import com.pharma.PharmaApp.models.User;
import com.pharma.PharmaApp.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
    public ResponseDTO register(RegisterDTO regDTO) throws CustomException {
        // Check to see if the current email address has already been registered.
        if (Objects.nonNull(userRepository.findByEmail(regDTO.getEmail()))) {
            // If the email address has been registered then throw an exception.
            throw new CustomException("Cannot register: Duplicate user");
        }
        // first encrypt the password
        String safePass = regDTO.getPassword();
        try {
            safePass = hashPassword(regDTO.getPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        User user = new User(regDTO.getFirstName(), regDTO.getLastName(), regDTO.getEmail(), regDTO.getPhone(), regDTO.getZip(), safePass);
        
        try {
            // save the User
             userRepository.save(user);
            // success in creating
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
