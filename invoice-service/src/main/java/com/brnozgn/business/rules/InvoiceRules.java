package com.brnozgn.business.rules;

import java.util.UUID;

import com.brnozgn.business.constants.Messages;
import com.brnozgn.dataAccess.InvoiceRepository;
import com.brnozgn.demo.utilities.exceptions.BusinessException;

public class InvoiceRules {
	private InvoiceRepository repository;

	public void checkIfExistsByInvoiceId(UUID id) {
		if (repository.findById(id).get() == null) {
			throw new BusinessException(Messages.InvoiceIdNotFound);
		}

	}
}
