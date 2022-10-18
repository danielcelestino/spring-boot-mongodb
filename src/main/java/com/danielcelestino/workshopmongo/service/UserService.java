package com.danielcelestino.workshopmongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielcelestino.workshopmongo.domain.User;
import com.danielcelestino.workshopmongo.repository.UserRepository;
import com.danielcelestino.workshopmongo.service.exception.ObjectNotFoudException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	
	public User findById(String id){
		User user = repository.findById(id).orElseThrow(() -> new ObjectNotFoudException("Object not found!"));
		return user;
	}

}
