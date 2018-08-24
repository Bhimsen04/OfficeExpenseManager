package com.expense.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.expense.service.LoginService;
import com.expense.vo.RegisterEmployee;
import com.expense.vo.Login;
import com.expense.vo.StatusResponse;

@RestController
@RequestMapping("/login")
public class LoginController 
{
	LoginService service = new LoginService();

	@RequestMapping( value="/list" , method=RequestMethod.GET )
	public List<RegisterEmployee> fetchEmployees() 
	{
		return service.fetchEmployees();
	}
	
	@RequestMapping(value = "/empLogin", method = RequestMethod.POST, headers = "Accept=application/json")
	public StatusResponse loginUser(@RequestBody Login login) 
	{
		StatusResponse statusResponse = service.loginUser(login);
		System.out.println("In LoginController StatusMessage :- "+statusResponse.getStatusMessage());
		return statusResponse;
	}
	
}
