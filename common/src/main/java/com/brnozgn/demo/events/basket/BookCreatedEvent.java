package com.brnozgn.demo.events.basket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookCreatedEvent {
	private String bookId;
	private int stock;
	private String messages;

}
