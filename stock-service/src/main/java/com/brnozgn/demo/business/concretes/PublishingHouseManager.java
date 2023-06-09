package com.brnozgn.demo.business.concretes;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.brnozgn.demo.business.abstracts.PublishingHouseService;
import com.brnozgn.demo.business.constants.Messages;
import com.brnozgn.demo.business.dto.requests.create.CreatePublishingHouseRequest;
import com.brnozgn.demo.business.dto.requests.update.UpdatePublishingHouseRequest;
import com.brnozgn.demo.business.dto.responses.create.CreatePublishingHouseResponse;
import com.brnozgn.demo.business.dto.responses.get.getAll.GetAllPublishingHouseResponse;
import com.brnozgn.demo.business.dto.responses.get.getById.GetByPublishingHouseIdResponse;
import com.brnozgn.demo.business.dto.responses.update.UpdatePublishingHouseResponse;
import com.brnozgn.demo.business.rules.PublishingHouseRules;
import com.brnozgn.demo.dataAccess.PublishingHouseRepository;
import com.brnozgn.demo.entities.PublishingHouse;
import com.brnozgn.demo.utilities.results.DataResult;
import com.brnozgn.demo.utilities.results.Result;
import com.brnozgn.demo.utilities.results.SuccessDataResult;
import com.brnozgn.demo.utilities.results.SuccessResult;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PublishingHouseManager implements PublishingHouseService {


	private PublishingHouseRepository repository;
	private ModelMapper modelMapper;
	private PublishingHouseRules rules;

	@Override
	public DataResult<CreatePublishingHouseResponse> add(CreatePublishingHouseRequest request) {
		this.rules.checkIfHouseExistByName(request.getName());
		PublishingHouse house = this.modelMapper.map(request, PublishingHouse.class);
		house.setId(UUID.randomUUID().toString());
		this.repository.save(house);
		CreatePublishingHouseResponse response = this.modelMapper.map(house, CreatePublishingHouseResponse.class);
		return new SuccessDataResult<CreatePublishingHouseResponse>(response, Messages.CreatedHouse);
	}

	public DataResult<UpdatePublishingHouseResponse> update(UpdatePublishingHouseRequest request) {
	    this.rules.checkIfHouseExistsById(request.getId());
	    this.rules.checkIfHouseExistByName(request.getName());
		PublishingHouse house = this.modelMapper.map(request, PublishingHouse.class);
		this.repository.save(house);
		UpdatePublishingHouseResponse response = this.modelMapper.map(house, UpdatePublishingHouseResponse.class);
		return new SuccessDataResult<UpdatePublishingHouseResponse>(response, Messages.UpdatedHouse);
	}

	public DataResult<List<GetAllPublishingHouseResponse>> getAll() {
		List<PublishingHouse> houses = this.repository.findAll();
		List<GetAllPublishingHouseResponse> responses = houses.stream()
				.map(house -> this.modelMapper.map(house, GetAllPublishingHouseResponse.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<GetAllPublishingHouseResponse>>(responses, Messages.ListedHouse);
	}

	public DataResult<GetByPublishingHouseIdResponse> getById(String id) {
		this.rules.checkIfHouseExistsById(id);
		PublishingHouse house = this.repository.findById(id).get();
		GetByPublishingHouseIdResponse houseId = this.modelMapper.map(house, GetByPublishingHouseIdResponse.class);
		return new SuccessDataResult<GetByPublishingHouseIdResponse>(houseId, Messages.ListedHouse);
	}

	
	public Result delete(String id) {
		this.rules.checkIfHouseExistsById(id);
		this.repository.deleteById(id);
		return new SuccessResult(Messages.DeletedHouse);
	}

}
