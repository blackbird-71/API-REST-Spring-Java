package com.api.rest.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.api.rest.example.entities.User;
import com.api.rest.example.repositories.UserRepository;

@Service
public class UserService {
	
@Autowired
private UserRepository userRepository;
	
	public Page<User> getUsers(int page, int size){
		//Pasamos como parametro numero de pagina y tamaño de pagina
		return userRepository.findAll(PageRequest.of(page,size));
	}
	
	public Page<String> getUsernames(int page, int size){
		//Pasamos como parametro numero de pagina y tamaño de pagina
		return userRepository.findUsernames(PageRequest.of(page,size));
	}
	
	
	public User getUserById(Integer userId){
		return userRepository.findById(userId).orElseThrow(
				()->new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("User %d not found", userId)));
	}
	
	public User getUserByUsername(String username){
		return userRepository.findByUsername(username).orElseThrow(
				()->new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("User %s not found", username)));
	}
	
	public User getUserByUsernameAndPassword(String username, String password){
		return userRepository.findByUsernameAndPassword(username,password).orElseThrow(
				()->new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("User %s not found", username)));
	}

	/*
	
	public User createUser(User user){
		if(users.stream().anyMatch(u->u.getUserName().equals(user.getUserName()))) {
			throw new ResponseStatusException(HttpStatus.CONFLICT,String.format("User %s already exists", user.getUserName()));
		}
		users.add(user);
		return user;
	}
	
	public User updateUser(User user, String username){
		User userToBeUpdated = getUserByUsername(username);
		userToBeUpdated.setNickName(user.getNickName());
		userToBeUpdated.setPassword(user.getPassword());
		return userToBeUpdated;
	}
	
	public void deleteUser(String username){
		User userByUsername = getUserByUsername(username);
		users.remove(userByUsername);
	}
	*/
}
