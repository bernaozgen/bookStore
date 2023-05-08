package com.brnozgn.demo.utilities.mapping;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
	ModelMapper forRequest();

	ModelMapper forResponse();
}
