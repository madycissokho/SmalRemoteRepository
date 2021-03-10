package com.saraya.rest.services.firstMadyWebService.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.saraya.rest.services.firstMadyWebService.bean.User;
import com.saraya.rest.services.firstMadyWebService.bean.UserDaoService;

@RestController
public class UserResource {
	@Autowired
	UserDaoService service;
	@GetMapping("/users")
	public List<User> retrieveAll(){
		return service.findAll();
	}
	@GetMapping("/users/{id}")
	public User retrieveOneUser(@PathVariable int id){
		return service.findOne(id);
	}
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user){
		User savedUser = service.save(user);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

}