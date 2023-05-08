package com.brnozgn.demo.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brnozgn.demo.entities.Novelist;

public interface NovelistRepository extends JpaRepository<Novelist, String>{
	Novelist findByName(String name);

	Novelist findBySurname(String surname);
}
