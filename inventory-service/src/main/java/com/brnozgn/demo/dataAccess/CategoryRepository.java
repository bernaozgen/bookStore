package com.brnozgn.demo.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brnozgn.demo.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, String> {

}
