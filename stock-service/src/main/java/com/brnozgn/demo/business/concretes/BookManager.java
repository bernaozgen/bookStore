package com.brnozgn.demo.business.concretes;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.brnozgn.demo.business.abstracts.BookService;
import com.brnozgn.demo.business.constants.Messages;
import com.brnozgn.demo.business.dto.requests.create.CreateBookRequest;
import com.brnozgn.demo.business.dto.requests.update.UpdateBookRequest;
import com.brnozgn.demo.business.dto.responses.create.CreateBookResponse;
import com.brnozgn.demo.business.dto.responses.get.getAll.GetAllBookResponse;
import com.brnozgn.demo.business.dto.responses.get.getById.GetByBookIdResponse;
import com.brnozgn.demo.business.dto.responses.update.UpdateBookResponse;
import com.brnozgn.demo.business.rules.BookRules;
import com.brnozgn.demo.dataAccess.BookRepository;
import com.brnozgn.demo.entities.Book;
import com.brnozgn.demo.utilities.mapping.ModelMapperService;
import com.brnozgn.demo.utilities.results.DataResult;
import com.brnozgn.demo.utilities.results.Result;
import com.brnozgn.demo.utilities.results.SuccessDataResult;
import com.brnozgn.demo.utilities.results.SuccessResult;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookManager implements BookService {

	private BookRepository repository;
	private ModelMapperService modelMapper;
	private BookRules rules;

	public DataResult<CreateBookResponse> add(CreateBookRequest bookRequest) {

		Book book = this.modelMapper.forRequest().map(bookRequest, Book.class);
		book.setId(UUID.randomUUID().toString());
		this.repository.save(book);

		CreateBookResponse response = this.modelMapper.forResponse().map(book, CreateBookResponse.class);

		return new SuccessDataResult<CreateBookResponse>(response, "AddBook");

	}

	public DataResult<UpdateBookResponse> update(UpdateBookRequest request) {
		this.rules.checkIfExistsByBookId(request.getId());
		Book book = this.modelMapper.forRequest().map(request, Book.class);
		this.repository.save(book);
		UpdateBookResponse response = this.modelMapper.forResponse().map(book, UpdateBookResponse.class);
		return new SuccessDataResult<UpdateBookResponse>(response, Messages.UpdatedBook);
	}

	public DataResult<List<GetAllBookResponse>> getAll() {
		List<Book> books = this.repository.findAll();
		List<GetAllBookResponse> responses = books.stream()
				.map(book -> this.modelMapper.forResponse().map(book, GetAllBookResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllBookResponse>>(responses, Messages.ListedBook);
	}

	public DataResult<GetByBookIdResponse> getById(String id) {
		this.rules.checkIfExistsByBookId(id);
		Book book = this.repository.findById(id).get();
		GetByBookIdResponse response = this.modelMapper.forResponse().map(book, GetByBookIdResponse.class);
		return new SuccessDataResult<GetByBookIdResponse>(response, Messages.ListedBook);
	}

	public Result delete(String id) {
		this.rules.checkIfExistsByBookId(id);
		this.repository.deleteById(id);
		return new SuccessResult(Messages.DeletedBook);
	}

	@Override
	public void updateBookStock(String bookId, int totalPcs) {
		this.rules.checkIfExistsByBookId(bookId);

		Book book = repository.findById(bookId).get();
		book.setStock(book.getStock() - totalPcs);
		this.repository.save(book);
	}

}
