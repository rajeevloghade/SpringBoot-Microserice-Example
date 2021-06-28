package io.javabrains.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import io.javabrains.model.SimpleClientData;

@Service("SimpleClientServiceImpl")
public class SimpleClientServiceImpl implements ISimpleClientService {

	@Value("${server.port}")
	private String portNumber;

	@Override
	public SimpleClientData getData(@PathVariable int dataId) {
		return new SimpleClientData(dataId, "name-" + dataId, dataId * 2, portNumber);
	}

}