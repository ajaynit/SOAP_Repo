package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


import io.spring.guides.gs_producing_web_service.GetEmployeeRequest;
import io.spring.guides.gs_producing_web_service.GetEmployeeResponse;

@Endpoint
public class EmployeeEndpoint {
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeEndpoint(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmployeeRequest")
	@ResponsePayload
	public GetEmployeeResponse getEmployee(@RequestPayload GetEmployeeRequest request) {
		GetEmployeeResponse response = new GetEmployeeResponse();
    	Employee emp = new Employee(request.getId(),request.getFirstname(),request.getLastname()); 
		response.setAcknowledgement(employeeRepository.acknowledgeLoad(emp));
		return response;
	}
}
