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
	
	public void existById(String cId) {
		if( this.repository.findById(cId).get()== null) {
			throw new BusinessException(Messages.CategoryIdNotFound);
			
		}
		
	}
	
	public void existsByName(String name) {
		if(this.repository.findByName(name) != null) {
			throw new BusinessException(Messages.CategoryUsed);
		}
	}

}
