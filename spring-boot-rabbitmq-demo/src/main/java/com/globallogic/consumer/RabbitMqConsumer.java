package com.globallogic.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.globallogic.dto.UserDto;

@Service
public class RabbitMqConsumer {

	private static final Logger logger = LoggerFactory.getLogger(RabbitMqConsumer.class);

	@RabbitListener(queues = "${rabbitmq.queue.name}")
	public void consumeMessage(UserDto message) {

		logger.info(String.format("Received : %s", message));

	}

}
