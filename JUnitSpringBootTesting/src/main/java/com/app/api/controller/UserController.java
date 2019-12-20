package com.app.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.api.infastucture.dto.UserDto;
import com.app.api.infrastructure.repository.database.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping
	public UserDto addUser(@RequestBody UserDto user) {
		return userRepository.save(user);
	}

	@GetMapping("/{id}")
	public UserDto getUser(@PathVariable int id) {
		return userRepository.findById(id).get();
	}

}
