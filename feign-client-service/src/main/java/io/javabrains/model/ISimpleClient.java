package io.javabrains.model;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "simple-client", url = "http://localhost:8085")
public interface ISimpleClient {

	@GetMapping(path = "/data/{dataId}", produces = "application/json")
	SimpleClientData getData(@PathVariable(name = "dataId") int dataId);

}