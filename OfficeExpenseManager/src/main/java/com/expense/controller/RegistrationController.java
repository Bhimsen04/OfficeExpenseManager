package com.expense.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.expense.service.RegistrationService;
import com.expense.vo.RegisterEmployee;
import com.expense.vo.StatusResponse;

@RestController
@RequestMapping("/registration")
public class RegistrationController
{
	RegistrationService service=new RegistrationService();
	
	@RequestMapping( value="/registration1" , method=RequestMethod.POST , headers="Accept=application/json" )
	public StatusResponse registerEmployee(@RequestBody RegisterEmployee employee) 
	{
		StatusResponse statusResponse=service.registerEmployee(employee);
		System.out.println("In RegistrationController StatusMessage :- \n"+statusResponse.getStatusMessage());
		return statusResponse;
	}
	
}




