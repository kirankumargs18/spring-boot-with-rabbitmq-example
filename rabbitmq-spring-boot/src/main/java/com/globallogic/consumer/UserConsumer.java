package com.globallogic.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.globallogic.entity.UserLogin;
import com.globallogic.entity.UserSignUp;
import com.globallogic.repository.LoginRepository;

@Component
public class UserConsumer {

	private static final Logger logger = LoggerFactory.getLogger(UserConsumer.class);

	@Autowired
	private LoginRepository repository;

	@RabbitListener(queues = "${rabbitmq.queue.name}")
	public void getDataFromQueueAndSavesIt(UserSignUp user) {

		UserLogin userLogin = new UserLogin();

		userLogin.setUsername(user.getUsername());
		userLogin.setEmail(user.getEmail());
		userLogin.setPassword(user.getPassword());

		repository.save(userLogin);

		logger.info("Data has been fetched from queue and saved to database");

	}

}
