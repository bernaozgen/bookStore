package com.brnozgn.demo.entities;

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
@Table(name = "baskets")
public class Basket {
 
	@Id
	@Column(name="id")
	private String id;
	@Column(name="book_id")
	private String bookId;
	@Column(name="total_pcs")
	private int totalPcs;
	@Column(name="lead_time")
	private int leadTime;
	@Column(name="tatl_price")
	private double totalPrice;

}
