package io.javabrains.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.model.SimpleClientData;
import io.javabrains.service.ISimpleClientService;

@RestController("SimpleClientControllerImpl")
public class SimpleClientControllerImpl implements ISimpleClientController {

	Logger log = LoggerFactory.getLogger(SimpleClientControllerImpl.class);

	private @Autowired ISimpleClientService simpleClientService;

	@GetMapping(path = "/data/{dataId}", produces = "application/json")
	@Override
	public SimpleClientData getData(@PathVariable int dataId) {
		log.trace("Inside SimpleClientControllerImpl class getData invoked with dataId : {}", dataId);
		return simpleClientService.getData(dataId);
	}

}