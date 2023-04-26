package com.brnozgn.demo.business.rules;

import org.springframework.stereotype.Service;

import com.brnozgn.demo.business.constants.Messages;
import com.brnozgn.demo.dataAccess.PublishingHouseRepository;
import com.brnozgn.demo.utilities.exceptions.BusinessException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PublishingHouseRules {
	private PublishingHouseRepository repository;

	public void checkIfHouseExistsById(String pId) {
		if(this.repository.findById(pId).get()==null) {
			throw new BusinessException(Messages.HouseIdNotFound);
		}
	}
	
	public void checkIfHouseExistByName(String name) {
		if(this.repository.findByName(name) != null) {
			throw new BusinessException(Messages.HouseNameUsed);
		}
	}
}
