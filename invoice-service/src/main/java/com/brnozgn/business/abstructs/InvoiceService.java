package com.brnozgn.business.abstructs;

import com.brnozgn.business.dto.requests.CreateInvoiceRequest;
import com.brnozgn.business.dto.responses.CreateInvoiceResponse;
import com.brnozgn.demo.utilities.results.DataResult;

public interface InvoiceService {
	DataResult<CreateInvoiceResponse> add(CreateInvoiceRequest request);

}
