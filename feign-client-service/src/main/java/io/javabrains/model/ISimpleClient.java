package io.javabrains.model;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "feign-client-data"/* , url = "http://localhost:9001" */ )
@RibbonClient(name = "feign-client-data")
public interface ISimpleClient {

	@GetMapping(path = "/data/{dataId}", produces = "application/json")
	SimpleClientData getData(@PathVariable(name = "dataId") int dataId);

}