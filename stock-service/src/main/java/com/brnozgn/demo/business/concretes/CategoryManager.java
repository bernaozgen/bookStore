package com.brnozgn.demo.business.concretes;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.brnozgn.demo.business.abstracts.CategoryService;
import com.brnozgn.demo.business.constants.Messages;
import com.brnozgn.demo.business.dto.requests.create.CreateCategoryRequest;
import com.brnozgn.demo.business.dto.requests.update.UpdateCategoryRequest;
import com.brnozgn.demo.business.dto.responses.create.CreateCategoryResponse;
import com.brnozgn.demo.business.dto.responses.get.getAll.GetAllCategoryResponse;
import com.brnozgn.demo.business.dto.responses.get.getById.GetByCategoryIdResponse;
import com.brnozgn.demo.business.dto.responses.update.UpdateCategoryResponse;
import com.brnozgn.demo.business.rules.CategoryRules;
import com.brnozgn.demo.dataAccess.CategoryRepository;
import com.brnozgn.demo.entities.Category;
import com.brnozgn.demo.utilities.results.DataResult;
import com.brnozgn.demo.utilities.results.Result;
import com.brnozgn.demo.utilities.results.SuccessDataResult;
import com.brnozgn.demo.utilities.results.SuccessResult;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {


	private CategoryRepository categoryRepository;
	private ModelMapper modelMapper;
	private CategoryRules rules;

	@Override
	public DataResult<CreateCategoryResponse> addCategory(CreateCategoryRequest createCategoryRequest) {
		this.rules.existsByName(createCategoryRequest.getName());
		Category category = modelMapper.map(createCategoryRequest, Category.class);
		category.setId(UUID.randomUUID().toString());
		categoryRepository.save(category);

		CreateCategoryResponse response = this.modelMapper.map(category, CreateCategoryResponse.class);

		return new SuccessDataResult<CreateCategoryResponse>(response, Messages.AddCategory);
	}

	public DataResult<UpdateCategoryResponse> updateCategory(UpdateCategoryRequest updateCategoryRequest) {
		this.rules.existById(updateCategoryRequest.getId());
		this.rules.existsByName(updateCategoryRequest.getName());
		Category category = this.modelMapper.map(updateCategoryRequest, Category.class);
		this.categoryRepository.save(category);
		UpdateCategoryResponse response = this.modelMapper.map(category, UpdateCategoryResponse.class);

		return new SuccessDataResult<UpdateCategoryResponse>(response, Messages.UpdatedCategory);
	}

	public DataResult<List<GetAllCategoryResponse>> getAll() {
		List<Category> categories = this.categoryRepository.findAll();
		List<GetAllCategoryResponse> allCategoryResponses = categories.stream()
				.map(category -> this.modelMapper.map(category, GetAllCategoryResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllCategoryResponse>>(allCategoryResponses, Messages.ListedCategory);
	}

	public DataResult<GetByCategoryIdResponse> getById(String id) {
		this.rules.existById(id);
		Category category = this.categoryRepository.findById(id).get();
		GetByCategoryIdResponse getByCategoryId = this.modelMapper.map(category, GetByCategoryIdResponse.class);

		return new SuccessDataResult<GetByCategoryIdResponse>(getByCategoryId, Messages.ListedCategory);
	}

	public Result delete(String id) {
		this.rules.existById(id);
		this.categoryRepository.deleteById(id);
		return new SuccessResult(Messages.DeletedCategory);
	}

}
