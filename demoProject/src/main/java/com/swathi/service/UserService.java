package com.swathi.service;

import com.swathi.dto.UserDTO;
import com.swathi.exception.UserException;

public interface UserService {

	// to Post user 
	public String postUserData(UserDTO user) throws UserException;
	
}
