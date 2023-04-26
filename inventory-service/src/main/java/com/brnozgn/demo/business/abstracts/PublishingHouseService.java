package com.brnozgn.demo.business.abstracts;

import java.util.List;

import com.brnozgn.demo.business.dto.requests.create.CreatePublishingHouseRequest;
import com.brnozgn.demo.business.dto.requests.update.UpdatePublishingHouseRequest;
import com.brnozgn.demo.business.dto.responses.create.CreatePublishingHouseResponse;
import com.brnozgn.demo.business.dto.responses.get.getAll.GetAllPublishingHouseResponse;
import com.brnozgn.demo.business.dto.responses.get.getById.GetByPublishingHouseIdResponse;
import com.brnozgn.demo.business.dto.responses.update.UpdatePublishingHouseResponse;
import com.brnozgn.demo.utilities.results.DataResult;
import com.brnozgn.demo.utilities.results.Result;

public interface PublishingHouseService {
	DataResult<CreatePublishingHouseResponse> add(CreatePublishingHouseRequest request);

	DataResult<UpdatePublishingHouseResponse> update(UpdatePublishingHouseRequest request);

	DataResult<List<GetAllPublishingHouseResponse>> getAll();

	DataResult<GetByPublishingHouseIdResponse> getById(String pId);

	Result delete(String pId);
}
