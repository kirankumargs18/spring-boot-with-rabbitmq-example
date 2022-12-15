package com.globallogic.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class UserConsumer {

	private static final Logger logger = LoggerFactory.getLogger(UserConsumer.class);

	@RabbitListener(queues = "${rabbitmq.queue.name}")
	public void consumeUserFromProducer(String message) {
		
		logger.info("Received User : "+message);

	}

}
