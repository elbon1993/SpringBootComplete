package com.elbon.restful.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.elbon.restful.exception.UserNotFoundException;
import com.elbon.restful.model.User;
import com.elbon.restful.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("users")
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@GetMapping("users/{id}")
	public User getUser(@PathVariable int id) {
		return userService.getUser(id);
	}

	@GetMapping("v2/users/{id}")
	public User getUserWithException(@PathVariable int id) {
		User user = userService.getUser(id);
		if (user == null) {
			throw new UserNotFoundException("User not found with id=" + id);
		}
		return user;
	}
	
	@PostMapping("users")
	public void createUser(@RequestBody User user) {
		userService.saveUser(user);
	}

	@PostMapping("v2/users")
	public ResponseEntity<Object> createUserWithStatus(@RequestBody User user) {
		User newUser = userService.saveUser(user);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId())
				.toUri();
		return ResponseEntity.status(HttpStatus.CREATED).location(uri).build();
	}
	
	@DeleteMapping("users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = userService.deleteUser(id);
		if(user == null) {
			throw new UserNotFoundException("User not found with id:"+id);
		}
	}
	
}
