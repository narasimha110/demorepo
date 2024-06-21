package com.demo.services;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	 @Autowired
	    private EmployeeRepo employeeRepo;
	 
	    @Autowired
	    private ModelMapper mapper;
	 
	    // Spring will create the implementation
	    // for this class
	    // and will inject the bean here (proxy)
	    @Autowired
	    private AddressClient addressClient;
	 
	    public EmployeeResponse getEmployeeById(int id) {
	 
	        Optional<Employee> employee = employeeRepo.findById(id);
	        EmployeeResponse employeeResponse = mapper.map(employee, EmployeeResponse.class);
	 
	        // Using FeignClient
	        ResponseEntity<AddressResponse> addressResponse = addressClient.getAddressByEmployeeId(id);
	        employeeResponse.setAddressResponse(addressResponse.getBody());
	 
	        return employeeResponse;
	    }
}
