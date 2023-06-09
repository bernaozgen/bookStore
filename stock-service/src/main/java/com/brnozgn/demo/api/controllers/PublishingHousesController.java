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

import com.brnozgn.demo.business.abstracts.PublishingHouseService;
import com.brnozgn.demo.business.dto.requests.create.CreatePublishingHouseRequest;
import com.brnozgn.demo.business.dto.requests.update.UpdatePublishingHouseRequest;
import com.brnozgn.demo.business.dto.responses.create.CreatePublishingHouseResponse;
import com.brnozgn.demo.business.dto.responses.get.getAll.GetAllPublishingHouseResponse;
import com.brnozgn.demo.business.dto.responses.get.getById.GetByPublishingHouseIdResponse;
import com.brnozgn.demo.business.dto.responses.update.UpdatePublishingHouseResponse;
import com.brnozgn.demo.utilities.results.DataResult;
import com.brnozgn.demo.utilities.results.Result;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("api/publishingHouses")
public class PublishingHousesController {

	private PublishingHouseService service;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public DataResult<CreatePublishingHouseResponse> add(@RequestBody @Valid CreatePublishingHouseRequest request) {
		return this.service.add(request);
	}

	@PutMapping
	public DataResult<UpdatePublishingHouseResponse> update(@RequestBody @Valid UpdatePublishingHouseRequest request) {
		return this.service.update(request);
	}

	@GetMapping
	public DataResult<List<GetAllPublishingHouseResponse>> getAll() {
		return this.service.getAll();
	}

	@GetMapping("/{id}")
	public DataResult<GetByPublishingHouseIdResponse> getById(@PathVariable @Valid String id) {
		return this.service.getById(id);
	}

	@DeleteMapping("/{id}")
	public Result delete(@PathVariable @Valid String id) {
		return this.service.delete(id);
	}

}
