package com.api.rest.example.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class RestControllerApi {
	@GetMapping
	public String helloWorld() {
		return "Hello world";
	}

}
