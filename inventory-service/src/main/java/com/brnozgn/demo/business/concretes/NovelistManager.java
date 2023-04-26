package com.brnozgn.demo.business.concretes;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.brnozgn.demo.business.abstracts.NovelistService;
import com.brnozgn.demo.business.constants.Messages;
import com.brnozgn.demo.business.dto.requests.create.CreateNovelistRequest;
import com.brnozgn.demo.business.dto.requests.update.UpdateNovelistRequest;
import com.brnozgn.demo.business.dto.responses.create.CreateNovelistResponse;
import com.brnozgn.demo.business.dto.responses.get.getAll.GetAllNovelistResponse;
import com.brnozgn.demo.business.dto.responses.get.getById.GetByNovelistIdResponse;
import com.brnozgn.demo.business.dto.responses.update.UpdateNovelistResponse;
import com.brnozgn.demo.business.rules.NovelistRules;
import com.brnozgn.demo.dataAccess.NovelistRepository;
import com.brnozgn.demo.entities.Novelist;
import com.brnozgn.demo.utilities.results.DataResult;
import com.brnozgn.demo.utilities.results.Result;
import com.brnozgn.demo.utilities.results.SuccessDataResult;
import com.brnozgn.demo.utilities.results.SuccessResult;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NovelistManager implements NovelistService {
	private NovelistRepository repository;
	private ModelMapper modelMapper;
	private NovelistRules rules;

	@Override
	public DataResult<CreateNovelistResponse> add(CreateNovelistRequest novelistRequest) {
		this.rules.checkIfExistsNovelistName(novelistRequest.getName(), novelistRequest.getSurname());
		Novelist novelist = this.modelMapper.map(novelistRequest, Novelist.class);
		novelist.setNId(UUID.randomUUID().toString());
		this.repository.save(novelist);
		CreateNovelistResponse response = this.modelMapper.map(novelist, CreateNovelistResponse.class);
		return new SuccessDataResult<CreateNovelistResponse>(response, Messages.CreatedNovelist);
	}

	public DataResult<UpdateNovelistResponse> update(UpdateNovelistRequest request) {
		this.rules.checkIfExistsNovelistId(request.getNId());
		Novelist novelist = this.modelMapper.map(request, Novelist.class);
		this.repository.save(novelist);

		UpdateNovelistResponse response = this.modelMapper.map(novelist, UpdateNovelistResponse.class);
		return new SuccessDataResult<UpdateNovelistResponse>(response, Messages.UpdatedNovelist);
	}

	@Override
	public DataResult<List<GetAllNovelistResponse>> getAll() {
		List<Novelist> novelists = this.repository.findAll();
		List<GetAllNovelistResponse> responses = novelists.stream()
				.map(novelist -> this.modelMapper.map(novelist, GetAllNovelistResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllNovelistResponse>>(responses, Messages.ListedNovelist);
	}

	public DataResult<GetByNovelistIdResponse> getById(String nId) {
		this.rules.checkIfExistsNovelistId(nId);
		Novelist novelist = this.repository.findById(nId).get();
		GetByNovelistIdResponse response = this.modelMapper.map(novelist, GetByNovelistIdResponse.class);
		return new SuccessDataResult<GetByNovelistIdResponse>(response, Messages.ListedNovelist);
	}

	public Result delete(String nId) {
		this.rules.checkIfExistsNovelistId(nId);
		this.repository.deleteById(nId);

		return new SuccessResult(Messages.DeletedNovelist);
	}

}
