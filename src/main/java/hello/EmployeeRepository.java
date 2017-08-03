package hello;



import org.springframework.stereotype.Component;


@Component
public class EmployeeRepository  {


	public String acknowledgeLoad(Employee emp) {
		

		return "Loaded successfully";
	}
}
