package com.swathi.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.swathi.entity.User;

public interface UserRepository  extends PagingAndSortingRepository<User, Integer>{
	
}
