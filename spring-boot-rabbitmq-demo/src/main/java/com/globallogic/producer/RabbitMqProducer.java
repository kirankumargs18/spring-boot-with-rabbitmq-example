package com.globallogic.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.globallogic.dto.UserDto;

/**
 * This class produces a message and places in RabbitMQ exchange
 */

@Service
public class RabbitMqProducer {

	private static final Logger logger = LoggerFactory.getLogger(RabbitMqProducer.class);

	@Value("${rabbitmq.queue.exchange}")
	private String exchange;

	@Value("${rabbitmq.routing.key}")
	private String routingKey;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	/**
	 * This method will place message in exchange
	 */
	public void sendMessage(UserDto message) {

		logger.info(String.format("Message sent --> %s", message));

		rabbitTemplate.convertAndSend(exchange, routingKey, message);

	}

}
