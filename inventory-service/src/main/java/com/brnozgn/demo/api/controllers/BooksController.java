package com.brnozgn.demo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.brnozgn.demo.business.abstracts.BookService;
import com.brnozgn.demo.business.dto.requests.create.CreateBookRequest;
import com.brnozgn.demo.business.dto.requests.update.UpdateBookRequest;
import com.brnozgn.demo.business.dto.responses.create.CreateBookResponse;
import com.brnozgn.demo.business.dto.responses.get.getAll.GetAllBookResponse;
import com.brnozgn.demo.business.dto.responses.get.getById.GetByBookIdResponse;
import com.brnozgn.demo.business.dto.responses.update.UpdateBookResponse;
import com.brnozgn.demo.utilities.results.DataResult;
import com.brnozgn.demo.utilities.results.Result;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/books")
@AllArgsConstructor
public class BooksController {
    @Autowired
	private BookService bookService;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public DataResult<CreateBookResponse> add(@RequestBody @Valid CreateBookRequest bookRequest) {
		return this.bookService.add(bookRequest);
	}

	@PutMapping
	public DataResult<UpdateBookResponse> update(@RequestBody @Valid UpdateBookRequest request) {
		return this.bookService.update(request);
	}

	@GetMapping
	public DataResult<List<GetAllBookResponse>> getAll() {
		return this.bookService.getAll();
	}

	@GetMapping("/{id}")
	public DataResult<GetByBookIdResponse> getById(@PathVariable String id) {
		return this.bookService.getById(id);
	}

	@DeleteMapping("/{id}")
	public Result delete(String id) {
		return this.bookService.delete(id);
	}
}
