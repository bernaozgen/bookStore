package com.brnozgn.business.abstructs;

import java.util.UUID;

import com.brnozgn.business.dto.requests.CreateInvoiceRequest;
import com.brnozgn.business.dto.requests.UpdateInvoiceRequest;
import com.brnozgn.business.dto.responses.CreateInvoiceResponse;
import com.brnozgn.business.dto.responses.GetByInvoiceResponse;
import com.brnozgn.business.dto.responses.UpdateInvoiceResponse;
import com.brnozgn.demo.utilities.results.DataResult;
import com.brnozgn.demo.utilities.results.Result;

public interface InvoiceService {
	DataResult<CreateInvoiceResponse> add(CreateInvoiceRequest request);

	DataResult<UpdateInvoiceResponse> update(UpdateInvoiceRequest request);

	Result delete(UUID id);

	DataResult<GetByInvoiceResponse> getById(UUID id);

}
