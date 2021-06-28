package io.javabrains.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import io.javabrains.model.SimpleClientData;

@Service("SimpleClientServiceImpl")
public class SimpleClientServiceImpl implements ISimpleClientService {

	Logger log = LoggerFactory.getLogger(SimpleClientServiceImpl.class);

	@Value("${server.port}")
	private String portNumber;

	@Override
	public SimpleClientData getData(@PathVariable int dataId) {
		log.debug("Inside SimpleClientServiceImpl class getData invoked with dataId : {}", dataId);
		SimpleClientData simpleClientData = new SimpleClientData(dataId, "name-" + dataId, dataId * 2, portNumber);
		log.info("SimpleClientData Object after getData invoked with dataId and returing : {}", simpleClientData);
		return simpleClientData;
	}

}