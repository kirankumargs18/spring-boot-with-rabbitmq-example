package com.globallogic.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfiguration {

	@Value("${rabbitmq.queue.name}")
	private String queue;

	@Value("${rabbitmq.exchange.name}")
	private String exchange;

	@Value("${rabbitmq.routing.key}")
	private String routingKey;

	@Bean
	public Queue queue() {

		return new Queue(queue);
	}

	@Bean
	public TopicExchange topicExchange() {

		return new TopicExchange(exchange);
	}

	@Bean
	public Binding binding() {

		return BindingBuilder.bind(queue()).to(topicExchange()).with(routingKey);
	}

	@Bean
	public Jackson2JsonMessageConverter messageConverter() {

		return new Jackson2JsonMessageConverter();
	}

	/**
	 * Spring boot auto configuration provides the following beans
	 * 
	 * Connection Factory
	 * 
	 * RabbitTemplate
	 * 
	 * RabbitAdmin
	 * 
	 */

}
