package com.expense.dao;

import org.jongo.Jongo;

import com.expense.util.MongoDbUtil;
import com.expense.vo.RegisterEmployee;

public class ProfileDao 
{

	public RegisterEmployee employeeDetails(long empId) 
	{
		RegisterEmployee employee=new Jongo(MongoDbUtil.getDB()).getCollection("Employee")
				          .findOne("{empId:#}", empId).as(RegisterEmployee.class);
		return employee;
	}
	
}
