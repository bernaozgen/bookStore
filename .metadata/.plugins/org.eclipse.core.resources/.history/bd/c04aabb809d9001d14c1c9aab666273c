package com.brnozgn.demo.business.abstracts;

import java.util.List;

import com.brnozgn.demo.business.dto.requests.create.CreateCategoryRequest;
import com.brnozgn.demo.business.dto.requests.update.UpdateCategoryRequest;
import com.brnozgn.demo.business.dto.responses.create.CreateCategoryResponse;
import com.brnozgn.demo.business.dto.responses.get.getAll.GetAllCategoryResponse;
import com.brnozgn.demo.business.dto.responses.get.getById.GetByCategoryId;
import com.brnozgn.demo.business.dto.responses.update.UpdateCategoryResponse;
import com.brnozgn.demo.utilities.results.DataResult;
import com.brnozgn.demo.utilities.results.Result;

public interface CategoryService {

	DataResult<CreateCategoryResponse> addCategory(CreateCategoryRequest createCategoryRequest);

	DataResult<UpdateCategoryResponse> updateCategory(UpdateCategoryRequest updateCategoryRequest);

	DataResult<List<GetAllCategoryResponse>> getAll();

	DataResult<GetByCategoryId> getById(String id);

	Result delete(String id);

}
