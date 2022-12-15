package com.globallogic.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.globallogic.entity.UserSignUp;
import com.globallogic.repository.SignupRepository;

@Component
public class UserProducer {

	private static final Logger logger = LoggerFactory.getLogger(UserProducer.class);

	@Value("${rabbitmq.exchange.name}")
	private String exchange;

	@Value("${rabbitmq.routing.key}")
	private String routingKey;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private SignupRepository repository;

	public void sendDataToConsumer() {

		UserSignUp userSignUp = new UserSignUp();

		userSignUp.setId("3");
		userSignUp.setName("Kiran Kumar G S");
		userSignUp.setUsername("kirangs");
		userSignUp.setEmail("kiran@gmail.com");
		userSignUp.setPassword("kiran");
		userSignUp.setAddress("Bangalore");

		repository.save(userSignUp);

		rabbitTemplate.convertAndSend(exchange, routingKey, userSignUp);
		
		logger.info("Data has been sent to exchange");

	}

}
