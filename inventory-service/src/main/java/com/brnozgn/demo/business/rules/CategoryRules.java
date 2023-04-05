package com.brnozgn.demo.business.rules;

import org.springframework.stereotype.Service;

import com.brnozgn.demo.business.constants.Messages;
import com.brnozgn.demo.dataAccess.CategoryRepository;
import com.brnozgn.demo.utilities.exceptions.BusinessException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CategoryRules {
	private CategoryRepository repository;
	
	public void existById(String id) {
		if( this.repository.findById(id).get()== null) {
			throw new BusinessException(Messages.CategoryIdNotFound);
			
		}
	}

}
