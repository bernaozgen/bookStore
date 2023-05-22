package com.brnozgn.demo.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.brnozgn.demo.events.basket.BookCreatedEvent;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BasketProducer {
	private static final Logger LOGGER = LoggerFactory.getLogger(BasketProducer.class);

	private final KafkaTemplate<String, Object> kafkaTemplate;

	public void sendMessage(BookCreatedEvent bookCreatedEvent) {
		LOGGER.info(String.format("Book Created Event => %s", bookCreatedEvent.toString()));

		Message<BookCreatedEvent> message = MessageBuilder.withPayload(bookCreatedEvent)
				.setHeader(KafkaHeaders.TOPIC, "basket-created").build();
		kafkaTemplate.send(message);
	}

}
