package com.globallogic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.producer.UserProducer;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	@Autowired
	private UserProducer userProducer;

	@GetMapping("/send")
	public ResponseEntity<String> placeUserInTheExchange() {

		userProducer.sendUserObjectToConsumer();
		return new ResponseEntity<String>("Placed user in the exchange", HttpStatus.OK);
	}

}
