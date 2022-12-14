package com.danielcelestino.workshopmongo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielcelestino.workshopmongo.domain.Post;
import com.danielcelestino.workshopmongo.repository.PostRepository;
import com.danielcelestino.workshopmongo.service.exception.ObjectNotFoudException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;

	public List<Post> findAll() {
		return repository.findAll();
	}

	public Post findById(String id) {
		Post post = repository.findById(id).orElseThrow(() -> new ObjectNotFoudException("Object not found!"));
		return post;
	}
	
	public List<Post> findByTitle(String text){
		return repository.searchTitle(text);
	}
	
	public List<Post> findByFullSearch(String text, Date dateMin, Date dateMax){
		dateMax = new Date(dateMax.getTime()); //encontrando a data 4 horas depois
		return repository.fullSearchTitle(text,dateMin,dateMax);
	}

	

}
