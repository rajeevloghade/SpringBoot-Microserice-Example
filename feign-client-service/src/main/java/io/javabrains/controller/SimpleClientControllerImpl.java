package io.javabrains.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.model.ISimpleClient;
import io.javabrains.model.SimpleClientData;
import lombok.RequiredArgsConstructor;

@RestController("SimpleClientControllerImpl")
@RequiredArgsConstructor
public class SimpleClientControllerImpl {

	Logger log = LoggerFactory.getLogger(SimpleClientControllerImpl.class);

	private @Autowired ISimpleClient simpleClient;

	@GetMapping(path = "/data/{id}", produces = "application/json")
	public SimpleClientData getData(@PathVariable int id) {
		log.trace("Inside SimpleClientControllerImpl class getData invoked with dataId : {}", id);
		return simpleClient.getData(id);
	}
}