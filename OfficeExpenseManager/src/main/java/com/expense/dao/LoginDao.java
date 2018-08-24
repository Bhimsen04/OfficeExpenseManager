package com.expense.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jongo.Jongo;

import com.expense.constants.StatusConstants;
import com.expense.util.MongoDbUtil;
import com.expense.vo.RegisterEmployee;
import com.expense.vo.Login;
import com.expense.vo.StatusResponse;

public class LoginDao
{
	
	public List<RegisterEmployee> fetchEmployees() 
	{
		List<RegisterEmployee> list=new ArrayList<RegisterEmployee>();
		Iterator<RegisterEmployee> allEmployees = new Jongo(MongoDbUtil.getDB()).getCollection("Employee")
                						  .find().as(RegisterEmployee.class).iterator();

		while(allEmployees.hasNext())
		{
			RegisterEmployee employee=allEmployees.next();
			System.out.println(employee.getName());
			list.add(employee);
		}
		return list;
	}
	
	public StatusResponse loginUser(Login login) 
	{
		StatusResponse statusResponse = new StatusResponse();
		RegisterEmployee emp = new Jongo(MongoDbUtil.getDB()).getCollection("Employee")
				.findOne("{emailId:#,password:#}", login.getEmailId(), login.getPassword()).as(RegisterEmployee.class);
		/*
		 * .getCollection("registration").aggregate("{$match:{$or:[{email:#},
		 * {mobileNo:9742034125},{$and:[{password:#}]}]}}",
		 * email,password).as(Registration.class);
		 */

		if (emp != null && emp.getStatus().equalsIgnoreCase("activate")) 
		{
			statusResponse.setStatusCode(StatusConstants.STATUS_SUCCESS_CODE);
			statusResponse.setStatusMessage(StatusConstants.STATUS_LOGIN_MESSAGE);
			statusResponse.setEmpId(emp.getEmpId());
			return statusResponse;
		} 
		else if (emp != null && emp.getStatus().equalsIgnoreCase("deActivate")) 
		{
			statusResponse.setStatusCode(StatusConstants.STATUS_SUCCESS_CODE);
			statusResponse.setStatusMessage(StatusConstants.STATUS_DEACTIVATE_MESSAGE);
			statusResponse.setEmpId(emp.getEmpId());
			return statusResponse;
		}
		else 
		{
			statusResponse.setStatusCode(StatusConstants.STATUS_UNSUCCESS_CODE);
			statusResponse.setStatusMessage(StatusConstants.STATUS_LOGIN_FAILED_MESSAGE);
			return statusResponse;
		}
	}

}
