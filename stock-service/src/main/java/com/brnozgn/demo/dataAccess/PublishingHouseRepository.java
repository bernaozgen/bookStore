package com.brnozgn.demo.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brnozgn.demo.entities.PublishingHouse;

public interface PublishingHouseRepository extends JpaRepository<PublishingHouse, String>{
	PublishingHouse findByName(String name);
}
