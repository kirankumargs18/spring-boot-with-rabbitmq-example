package com.globallogic.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.globallogic.dto.UserDto;

@Service
public class UserProducer {

	private static final Logger logger = LoggerFactory.getLogger(UserProducer.class);

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Value("${rabbitmq.exchange.name}")
	private String exchange;

	@Value("${rabbitmq.routing.key}")
	private String routingKey;

	public void sendUserObjectToConsumer() {

		String message="Message";
		UserDto user = new UserDto();
		user.setName("Kiran Kumar G S");
		user.setAge(23);
		user.setAddress("Bangalore");
		
		

		rabbitTemplate.convertAndSend(exchange, routingKey, message);
		
		logger.info("Placed "+user+" in the exchange");

	}

}
