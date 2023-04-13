package com.brnozgn.demo.business.rules;

import org.springframework.stereotype.Service;

import com.brnozgn.demo.business.constants.Messages;
import com.brnozgn.demo.dataAccess.BookRepository;
import com.brnozgn.demo.utilities.exceptions.BusinessException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BookRules {

	private BookRepository repository;
	
	public void checkIfExistsByBookId(String id) {
		if(this.repository.findById(id).get() != null) {
			throw new BusinessException(Messages.BookIdNotFound);
		}
	}

}
