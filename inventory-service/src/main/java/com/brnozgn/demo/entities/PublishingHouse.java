package com.brnozgn.demo.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "publishingHouses")
public class PublishingHouse {

	@Id
	@Column(name = "pId")
	private String pId;

	@Column(name = "name")
	private String name;

	@Column(name = "explication")
	private String explication;

	@OneToMany(mappedBy = "publishingHouse")
	private List<Book> books;
}
