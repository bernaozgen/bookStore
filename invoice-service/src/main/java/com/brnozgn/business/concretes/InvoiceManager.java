package com.brnozgn.business.concretes;

import org.springframework.stereotype.Service;

import com.brnozgn.business.abstructs.InvoiceService;
import com.brnozgn.business.constants.Messages;
import com.brnozgn.business.dto.requests.CreateInvoiceRequest;
import com.brnozgn.business.dto.responses.CreateInvoiceResponse;
import com.brnozgn.dataAccess.InvoiceRepository;
import com.brnozgn.demo.utilities.mapping.ModelMapperService;
import com.brnozgn.demo.utilities.results.DataResult;
import com.brnozgn.demo.utilities.results.SuccessDataResult;
import com.brnozgn.entities.Invoice;

@Service
public class InvoiceManager implements InvoiceService {
	private InvoiceRepository repository;
	private ModelMapperService mapperService;

	@Override
	public DataResult<CreateInvoiceResponse> add(CreateInvoiceRequest request) {
		Invoice invoice = this.mapperService.forRequest().map(request, Invoice.class);
		this.repository.save(invoice);
		CreateInvoiceResponse response = this.mapperService.forResponse().map(invoice, CreateInvoiceResponse.class);
		return new SuccessDataResult<CreateInvoiceResponse>(response, Messages.Added);
	}

}
