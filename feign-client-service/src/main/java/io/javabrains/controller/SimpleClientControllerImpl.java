package io.javabrains.controller;

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

	private @Autowired ISimpleClient simpleClient;

	@GetMapping(path="/data/{id}",produces = "application/json")
	public SimpleClientData getData(@PathVariable int id) {
		return simpleClient.getData(id);
	}
}