package com.brnozgn.demo.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.brnozgn.demo.business.abstracts.BookService;
import com.brnozgn.demo.events.basket.BookCreatedEvent;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class BasketConsumer {

	private final BookService bookService;

	@KafkaListener(topics = "basket-created", groupId = "basket-create")
	public void consume(BookCreatedEvent event) {
		bookService.updateBookStock(event.getBookId(), event.getTotalPcs());
		log.info(String.format("Basket created event consumed {}", event.toString()));
		

	}
}
