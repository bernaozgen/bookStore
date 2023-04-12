package com.brnozgn.demo.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.brnozgn.demo.business.abstracts.NovelistService;
import com.brnozgn.demo.business.dto.requests.create.CreateNovelistRequest;
import com.brnozgn.demo.business.dto.requests.update.UpdateNovelistRequest;
import com.brnozgn.demo.business.dto.responses.create.CreateNovelistResponse;
import com.brnozgn.demo.business.dto.responses.get.getAll.GetAllNovelistResponse;
import com.brnozgn.demo.business.dto.responses.get.getById.GetByNovelistIdResponse;
import com.brnozgn.demo.business.dto.responses.update.UpdateNovelistResponse;
import com.brnozgn.demo.utilities.results.DataResult;
import com.brnozgn.demo.utilities.results.Result;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/novelists")
@AllArgsConstructor
public class NovelistsController {
	private NovelistService service;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public DataResult<CreateNovelistResponse> add(CreateNovelistRequest novelistRequest) {
		return this.service.add(novelistRequest);
	}

	@PutMapping
	public DataResult<UpdateNovelistResponse> update(UpdateNovelistRequest request) {
		return this.service.update(request);
	}

	@GetMapping
	public DataResult<List<GetAllNovelistResponse>> getAll() {
		return this.service.getAll();
	}

	@GetMapping("/{id}")
	public DataResult<GetByNovelistIdResponse> getById(String id) {
		return this.service.getById(id);
	}

	@DeleteMapping("/{id}")
	public Result delete(String id) {
		return this.service.delete(id);
	}
}
