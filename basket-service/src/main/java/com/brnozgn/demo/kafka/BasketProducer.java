package com.brnozgn.demo.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.brnozgn.demo.events.basket.BookCreatedEvent;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Service
@Slf4j
public class BasketProducer {

	private final KafkaTemplate<String, Object> kafkaTemplate;

	public void sendMessage(BookCreatedEvent bookCreatedEvent) {
		log.info(String.format("Book Created Event => %s", bookCreatedEvent.toString()));

		Message<BookCreatedEvent> message = MessageBuilder.withPayload(bookCreatedEvent)
				.setHeader(KafkaHeaders.TOPIC, "basket-created").build();
		kafkaTemplate.send(message);
	}

}
