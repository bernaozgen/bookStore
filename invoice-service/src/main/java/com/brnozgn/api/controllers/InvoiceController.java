package com.brnozgn.api.controllers;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brnozgn.business.abstructs.InvoiceService;
import com.brnozgn.business.dto.requests.CreateInvoiceRequest;
import com.brnozgn.business.dto.requests.UpdateInvoiceRequest;
import com.brnozgn.business.dto.responses.CreateInvoiceResponse;
import com.brnozgn.business.dto.responses.GetByInvoiceResponse;
import com.brnozgn.business.dto.responses.UpdateInvoiceResponse;
import com.brnozgn.demo.utilities.results.DataResult;
import com.brnozgn.demo.utilities.results.Result;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/invoices")
@AllArgsConstructor
public class InvoiceController {
	private final InvoiceService service;

	@PostMapping
	public DataResult<CreateInvoiceResponse> add(CreateInvoiceRequest request) {
		return service.add(request);
	}

	@PutMapping
	public DataResult<UpdateInvoiceResponse> update(UpdateInvoiceRequest request) {
		return this.service.update(request);
	}

	@DeleteMapping("/{id}")
	public Result delete(UUID id) {
		return this.service.delete(id);
	}

	@GetMapping("/{id}")
	public DataResult<GetByInvoiceResponse> getById(UUID id) {
		return this.service.getById(id);
	}

}
