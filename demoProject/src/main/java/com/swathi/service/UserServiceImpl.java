package com.swathi.service;

import java.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swathi.dto.UserDTO;
import com.swathi.entity.User;
import com.swathi.exception.UserException;
import com.swathi.repository.UserRepository;

@Service(value = "userService")
@Transactional
public class UserServiceImpl implements UserService{
	
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public String postUserData(UserDTO userDto) throws UserException {
	
		User user =  new User();
		
		user.setEmail(userDto.getEmail());
		user.setName(userDto.getName());
		user.setPhone(userDto.getPhone());
		user.setPassword(encryptPassword(userDto.getPassword()));
		
		userRepository.save(user);
		return "Success";
	}
	
	// To Encrypt password 
	private static String encryptPassword(String pwd) {
		return Base64.getEncoder().encodeToString(pwd.getBytes());
	}
	
	
	//To Decrypt Password
	private static String decryptPassword(String pwd) {
		return new String(Base64.getMimeDecoder().decode(pwd));
	}


}
