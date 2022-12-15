package com.globallogic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.producer.UserProducer;

@RestController
@RequestMapping("/api/v1/user-service")
public class UserController {

	@Autowired
	private UserProducer producer;

	@PostMapping
	public ResponseEntity<String> signupUser() {

		producer.sendDataToConsumer();

		return new ResponseEntity<String>("User signup is successful", HttpStatus.CREATED);
	}

}
