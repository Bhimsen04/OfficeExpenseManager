package com.expense.service;

import com.expense.dao.RegistrationDao;
import com.expense.vo.RegisterEmployee;
import com.expense.vo.StatusResponse;

public class RegistrationService 
{

	RegistrationDao dao=new RegistrationDao();
	
	public StatusResponse registerEmployee(RegisterEmployee emp) 
	{
		return dao.registerEmployee(emp);
	}
	
}
