package com.expense.service;

import com.expense.dao.ProfileDao;
import com.expense.vo.RegisterEmployee;

public class ProfileService 
{

	ProfileDao dao=new ProfileDao();
	public RegisterEmployee employeeDetails(long empId) 
	{
		return dao.employeeDetails(empId);
	}
	
}
