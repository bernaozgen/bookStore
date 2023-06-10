package com.brnozgn.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brnozgn.business.abstructs.InvoiceService;
import com.brnozgn.business.dto.requests.CreateInvoiceRequest;
import com.brnozgn.business.dto.responses.CreateInvoiceResponse;
import com.brnozgn.demo.utilities.results.DataResult;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/invoices")
@AllArgsConstructor
public class InvoiceController {
	private final InvoiceService service;

	public DataResult<CreateInvoiceResponse> add(CreateInvoiceRequest request) {
		return service.add(request);
	}

}
