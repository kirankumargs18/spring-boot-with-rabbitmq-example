package com.globallogic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.dto.UserDto;
import com.globallogic.producer.RabbitMqProducer;

@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {

	@Autowired
	private RabbitMqProducer rabbitMqProducer;

	@GetMapping("/send")
	public ResponseEntity<String> sendMessageToRabbitMqExchange() {
		
		UserDto userDto=new UserDto("Kiran", "Password");

		rabbitMqProducer.sendMessage(userDto);
		return new ResponseEntity<String>("Message sent to RabbitMq..", HttpStatus.OK);

	}

}
