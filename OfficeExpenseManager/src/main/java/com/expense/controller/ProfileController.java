package com.expense.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.expense.service.ProfileService;
import com.expense.vo.RegisterEmployee;

@RestController
@RequestMapping("/profile")
public class ProfileController 
{

	ProfileService service = new ProfileService();
	
	@RequestMapping( value="/profile1" , method=RequestMethod.GET)
	public RegisterEmployee employeeDetails(long empId)
	{
		RegisterEmployee employee = service.employeeDetails(empId);
	    System.out.println("In ProfileController Employee Details :- \n"+employee.get_id()+","+employee.getEmpId()+","+employee.getName()+","+employee.getDesignation()+","+employee.getSalary()+","+employee.getGender()+","+employee.getMobileNo()+","+employee.getEmailId()+","+employee.getPassword());
		return employee;
	}
	
}
