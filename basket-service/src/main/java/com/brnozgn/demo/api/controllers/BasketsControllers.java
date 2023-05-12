package com.brnozgn.demo.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.brnozgn.demo.business.abstracts.BasketService;
import com.brnozgn.demo.business.dto.requests.CreateBasketRequest;
import com.brnozgn.demo.business.dto.responses.CreateBasketResponse;
import com.brnozgn.demo.business.dto.responses.GetAllBasketResponse;
import com.brnozgn.demo.utilities.results.DataResult;
import com.brnozgn.demo.utilities.results.Result;

import lombok.AllArgsConstructor;

@RequestMapping("api/baskets")
@AllArgsConstructor
@RestController
public class BasketsControllers {
	private BasketService service;

	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public DataResult<CreateBasketResponse> add(CreateBasketRequest request) {
		return this.service.add(request);
	}
	
	@DeleteMapping("{/id}")
	public Result delete(String id) {
		return this.service.delete(id);
	}
	
	@GetMapping
	public DataResult<List<GetAllBasketResponse>> getAll(){
		return this.service.getAll();
	}
}
