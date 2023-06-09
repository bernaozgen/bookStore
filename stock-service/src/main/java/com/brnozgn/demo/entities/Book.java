package com.brnozgn.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
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

	@Column(name = "stock")
	private int stock;

	@ManyToOne
	@JoinColumn(name = "novelist_id")
	private Novelist novelist;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToOne
	@JoinColumn(name = "publishing_house_id")
	private PublishingHouse publishingHouse;

}
