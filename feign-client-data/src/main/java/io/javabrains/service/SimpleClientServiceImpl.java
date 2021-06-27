package io.javabrains.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import io.javabrains.model.SimpleClientData;

@Service("SimpleClientServiceImpl")
public class SimpleClientServiceImpl implements ISimpleClientService {

	@Override
	public SimpleClientData getData(@PathVariable int dataId) {
		return new SimpleClientData(dataId, "name-" + dataId, dataId * 2);
	}

}