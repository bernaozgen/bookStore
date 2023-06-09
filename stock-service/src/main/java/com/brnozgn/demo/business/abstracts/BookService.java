package com.brnozgn.demo.business.abstracts;

import java.util.List;

import com.brnozgn.demo.business.dto.requests.create.CreateBookRequest;
import com.brnozgn.demo.business.dto.requests.update.UpdateBookRequest;
import com.brnozgn.demo.business.dto.responses.create.CreateBookResponse;
import com.brnozgn.demo.business.dto.responses.get.getAll.GetAllBookResponse;
import com.brnozgn.demo.business.dto.responses.get.getById.GetByBookIdResponse;
import com.brnozgn.demo.business.dto.responses.update.UpdateBookResponse;
import com.brnozgn.demo.utilities.results.DataResult;
import com.brnozgn.demo.utilities.results.Result;

public interface BookService {
	DataResult<CreateBookResponse> add(CreateBookRequest bookRequest);

	DataResult<UpdateBookResponse> update(UpdateBookRequest request);

	DataResult<List<GetAllBookResponse>> getAll();

	DataResult<GetByBookIdResponse> getById(String id);

	Result delete(String id);

	void updateBookStock(String bookId, int stock);
}
