package com.neobank.project.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.neobank.project.entity.UserEntity;
import com.neobank.project.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;

	@RequestMapping(value = "get_all", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Iterable<UserEntity>> getAllUsers() {

		Iterable<UserEntity> users = userRepository.findAll();

		// Se hace las validaciones necesarias

		//
		return new ResponseEntity<>(users, HttpStatus.OK);

	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<UserEntity> addUser(@Valid @RequestBody UserEntity user) {

		UserEntity userResult = userRepository.save(user);
		if (user == null) {
			// validar cuando no ha sido posible grabar en la base de datos
		}
		
		return new ResponseEntity<>(userResult, HttpStatus.OK);

	}
	

}
