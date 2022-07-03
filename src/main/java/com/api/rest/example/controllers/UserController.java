package com.api.rest.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.example.entities.User;
import com.api.rest.example.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<Page<User>> getUsers(@RequestParam(required=false, defaultValue="0", value="page") int page,
			@RequestParam(required=false, defaultValue="1000", value="size") int size){
		return new ResponseEntity<Page<User>>(service.getUsers(page, size),HttpStatus.OK);
	}
	
	@GetMapping(value="/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable("userId") Integer userId){
		return new ResponseEntity<User>(service.getUserById(userId),HttpStatus.OK);
	}
	
	
	@GetMapping(value="/username/{username}")
	public ResponseEntity<User> getUserByUserName(@PathVariable("username") String username){
		return new ResponseEntity<User>(service.getUserByUsername(username),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<User> authenticate(@RequestBody User user){
		return new ResponseEntity<User>(service.getUserByUsernameAndPassword(user.getUsername(),user.getPassword()),HttpStatus.OK);
	}

/*
	@GetMapping(value="/{username}")
	public ResponseEntity<User> getUserByUserName(@PathVariable("username") String username){
		return new ResponseEntity<User>(userService.getUserByUsername(username),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		return new ResponseEntity<User>(userService.createUser(user),HttpStatus.CREATED);
	}
	
	@PutMapping(value="/{username}")
	public ResponseEntity<User> updateUser(@PathVariable("username") String username, @RequestBody User user){
		return new ResponseEntity<User>(userService.updateUser(user,username),HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{username}")
	public ResponseEntity<Void> deleteUser(@PathVariable("username") String username){
		userService.deleteUser(username);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
*/
}
