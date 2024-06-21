package com.demo.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "AddressServiceApplication", url = "http://localhost:8081", path = "/address")
public interface AddressClient {
	
	@GetMapping("{id}")
public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("id") int id);

	
	

}
