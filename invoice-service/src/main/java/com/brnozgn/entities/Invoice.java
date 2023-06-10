package com.brnozgn.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "invoices")
public class Invoice {

	@Id
	@Column(name = "id")
	private UUID id;
	@Column(name = "book_id")
	private String bookName;
	@Column(name = "total_pcs")
	private int totalPcs;
	@Column(name = "tatl_price")
	private double totalPrice;

}
