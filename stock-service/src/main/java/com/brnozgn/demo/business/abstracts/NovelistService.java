package com.brnozgn.demo.business.abstracts;


import java.util.List;

import com.brnozgn.demo.business.dto.requests.create.CreateNovelistRequest;
import com.brnozgn.demo.business.dto.requests.update.UpdateNovelistRequest;
import com.brnozgn.demo.business.dto.responses.create.CreateNovelistResponse;
import com.brnozgn.demo.business.dto.responses.get.getAll.GetAllNovelistResponse;
import com.brnozgn.demo.business.dto.responses.get.getById.GetByNovelistIdResponse;
import com.brnozgn.demo.business.dto.responses.update.UpdateNovelistResponse;
import com.brnozgn.demo.utilities.results.DataResult;
import com.brnozgn.demo.utilities.results.Result;

public interface NovelistService {
	DataResult<CreateNovelistResponse> add(CreateNovelistRequest novelistRequest);

	DataResult<UpdateNovelistResponse> update(UpdateNovelistRequest request);

	DataResult<List<GetAllNovelistResponse>> getAll();

	DataResult<GetByNovelistIdResponse> getById(String id);

	Result delete(String id);
}
