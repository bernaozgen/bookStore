package com.brnozgn.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books")
@Entity
public class Book {
	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "bookName")
	private String bookName;

	@Column(name = "explication")
	private String explication;

	@Column(name = "comment")
	private String comment;

	@Column(name = "price")
	private double price;

	@ManyToOne
	private Novelist novelist;

	@ManyToOne
	private Category category;

	@ManyToOne
	private PublishingHouse publishingHouse;


}
