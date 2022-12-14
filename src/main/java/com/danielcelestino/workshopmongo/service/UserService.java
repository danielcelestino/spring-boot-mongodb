package com.danielcelestino.workshopmongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielcelestino.workshopmongo.domain.User;
import com.danielcelestino.workshopmongo.dto.UserDTO;
import com.danielcelestino.workshopmongo.repository.UserRepository;
import com.danielcelestino.workshopmongo.service.exception.ObjectNotFoudException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(String id) {
		User user = repository.findById(id).orElseThrow(() -> new ObjectNotFoudException("Object not found!"));
		return user;
	}

	public User insert(User user) {
		return repository.insert(user);
	}

	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}

	public User update(User obj) {
		User user = findById(obj.getId());
		updateData(user, obj);
		return repository.save(user);
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}

	private void updateData(User user, User obj) {
		user.setEmail(obj.getEmail());
		user.setName(obj.getName());
	}

}
