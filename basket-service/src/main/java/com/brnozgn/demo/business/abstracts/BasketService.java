package com.brnozgn.demo.business.abstracts;

import java.util.List;

import com.brnozgn.demo.business.dto.requests.CreateBasketRequest;
import com.brnozgn.demo.business.dto.responses.CreateBasketResponse;
import com.brnozgn.demo.business.dto.responses.GetAllBasketResponse;
import com.brnozgn.demo.utilities.results.DataResult;
import com.brnozgn.demo.utilities.results.Result;

public interface BasketService {
	DataResult<CreateBasketResponse> add(CreateBasketRequest request);

	Result delete(String id);

	DataResult<List<GetAllBasketResponse>> getAll();

}
