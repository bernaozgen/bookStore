package com.brnozgn.demo.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brnozgn.demo.entities.Basket;

public interface BasketRepository extends JpaRepository<Basket, String> {

}
