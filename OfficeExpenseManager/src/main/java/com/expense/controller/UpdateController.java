package com.expense.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.expense.service.UpdateService;
import com.expense.vo.RegisterEmployee;
import com.expense.vo.StatusResponse;

@RestController
@RequestMapping("/update")
public class UpdateController 
{
	UpdateService service = new UpdateService();

	@RequestMapping( value="/update1" , method=RequestMethod.POST , headers="Accept=application/json" )
	public StatusResponse update(@RequestBody RegisterEmployee emp)
	{
		StatusResponse statusResponse = service.update(emp);
		System.out.println("In UpdateController StatusMessage :- \n"+statusResponse.getStatusMessage());
		return statusResponse;
	}
	
}
