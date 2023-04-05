package com.brnozgn.demo.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brnozgn.demo.entities.Book;

public interface BookRepository extends JpaRepository<Book, String> {

}
