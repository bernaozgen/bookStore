package com.brnozgn.demo.api.controllers;

import java.util.List;

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

import com.brnozgn.demo.business.abstracts.CategoryService;
import com.brnozgn.demo.business.dto.requests.create.CreateCategoryRequest;
import com.brnozgn.demo.business.dto.requests.update.UpdateCategoryRequest;
import com.brnozgn.demo.business.dto.responses.create.CreateCategoryResponse;
import com.brnozgn.demo.business.dto.responses.get.getAll.GetAllCategoryResponse;
import com.brnozgn.demo.business.dto.responses.get.getById.GetByCategoryIdResponse;
import com.brnozgn.demo.business.dto.responses.update.UpdateCategoryResponse;
import com.brnozgn.demo.utilities.results.DataResult;
import com.brnozgn.demo.utilities.results.Result;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RequestMapping("api/categories")
@RestController
@AllArgsConstructor
public class CategoriesController {
	private CategoryService categoryService;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED) // 201 döndürsün diye
	public DataResult<CreateCategoryResponse> addCategory(@RequestBody @Valid CreateCategoryRequest createCategoryRequest) {
		return this.categoryService.addCategory(createCategoryRequest);
	}

	@PutMapping
	public DataResult<UpdateCategoryResponse> updateCategory(@RequestBody @Valid UpdateCategoryRequest updateCategoryRequest) {
		return this.categoryService.updateCategory(updateCategoryRequest);
	}

	@GetMapping
	public DataResult<List<GetAllCategoryResponse>> getAll() {
		return this.categoryService.getAll();
	}

	@GetMapping("/{id}")
	public DataResult<GetByCategoryIdResponse> getById(@PathVariable @Valid String id) {
		return this.categoryService.getById(id);
	}

	@DeleteMapping("/{id}")
	public Result delete(@PathVariable @Valid String id) {
		return this.categoryService.delete(id);
	}

}
