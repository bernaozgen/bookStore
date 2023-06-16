package com.brnozgn.business.concretes;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.brnozgn.business.abstructs.InvoiceService;
import com.brnozgn.business.constants.Messages;
import com.brnozgn.business.dto.requests.CreateInvoiceRequest;
import com.brnozgn.business.dto.requests.UpdateInvoiceRequest;
import com.brnozgn.business.dto.responses.CreateInvoiceResponse;
import com.brnozgn.business.dto.responses.GetByInvoiceResponse;
import com.brnozgn.business.dto.responses.UpdateInvoiceResponse;
import com.brnozgn.business.rules.InvoiceRules;
import com.brnozgn.dataAccess.InvoiceRepository;
import com.brnozgn.demo.utilities.mapping.ModelMapperService;
import com.brnozgn.demo.utilities.results.DataResult;
import com.brnozgn.demo.utilities.results.Result;
import com.brnozgn.demo.utilities.results.SuccessDataResult;
import com.brnozgn.demo.utilities.results.SuccessResult;
import com.brnozgn.entities.Invoice;

@Service
public class InvoiceManager implements InvoiceService {
	private InvoiceRepository repository;
	private ModelMapperService mapperService;
	private InvoiceRules rules;

	@Override
	public DataResult<CreateInvoiceResponse> add(CreateInvoiceRequest request) {
		Invoice invoice = this.mapperService.forRequest().map(request, Invoice.class);
		this.repository.save(invoice);
		CreateInvoiceResponse response = this.mapperService.forResponse().map(invoice, CreateInvoiceResponse.class);
		return new SuccessDataResult<CreateInvoiceResponse>(response, Messages.Added);
	}

	@Override
	public DataResult<UpdateInvoiceResponse> update(UpdateInvoiceRequest request) {
		this.rules.checkIfExistsByInvoiceId(request.getId());
		Invoice invoice = this.mapperService.forRequest().map(request, Invoice.class);
		this.repository.save(invoice);
		UpdateInvoiceResponse response = this.mapperService.forResponse().map(invoice, UpdateInvoiceResponse.class);
		return new SuccessDataResult<UpdateInvoiceResponse>(response, Messages.Updated);
	}

	@Override
	public Result delete(UUID id) {
		this.rules.checkIfExistsByInvoiceId(id);
		this.repository.deleteById(id);
		return new SuccessResult(Messages.DeleteInvoiceId);
	}

	@Override
	public DataResult<GetByInvoiceResponse> getById(UUID id) {
		this.rules.checkIfExistsByInvoiceId(id);
		Invoice invoice = this.repository.findById(id).get();
		GetByInvoiceResponse response = this.mapperService.forResponse().map(invoice, GetByInvoiceResponse.class);

		return new SuccessDataResult<GetByInvoiceResponse>(response, Messages.ListedInvoice);
	}

}
