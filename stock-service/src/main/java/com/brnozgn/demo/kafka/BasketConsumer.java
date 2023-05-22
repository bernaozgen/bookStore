package com.brnozgn.demo.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.brnozgn.demo.business.abstracts.BookService;
import com.brnozgn.demo.events.basket.BookCreatedEvent;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BasketConsumer {

	private BookService bookService;
	private static final Logger LOGGER = LoggerFactory.getLogger(BasketConsumer.class);

	@KafkaListener(topics = "basket-created", groupId = "basket-create")
	public void consume(BookCreatedEvent event) {
		bookService.updateBookStock(event.getBookId(), event.getTotalPcs());
		LOGGER.info(String.format("Order event received in stock service => %s", event.toString()));
		

	}
}
