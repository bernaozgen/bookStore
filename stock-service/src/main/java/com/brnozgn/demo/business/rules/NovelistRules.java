package com.brnozgn.demo.business.rules;

import org.springframework.stereotype.Service;

import com.brnozgn.demo.business.constants.Messages;
import com.brnozgn.demo.dataAccess.NovelistRepository;
import com.brnozgn.demo.utilities.exceptions.BusinessException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class NovelistRules {
	private NovelistRepository repository;

	public void checkIfExistsNovelistId(String id) {
		if (this.repository.findById(id).get() == null) {
			throw new BusinessException(Messages.NovelistIdNotFound);
		}

	}

	public void checkIfExistsNovelistName(String name, String surname) {
		if (this.repository.findByName(name) != null && this.repository.findBySurname(surname) != null) {
			throw new BusinessException(Messages.Novelist);
		}
	}

}
