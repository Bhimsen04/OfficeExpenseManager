package com.expense.dao;

import org.jongo.Jongo;

import com.expense.constants.StatusConstants;
import com.expense.util.MongoDbUtil;
import com.expense.vo.Counters;
import com.expense.vo.RegisterEmployee;
import com.expense.vo.StatusResponse;

public class RegistrationDao
{
	public StatusResponse registerEmployee(RegisterEmployee employee) 
	{
		StatusResponse statusResponse = new StatusResponse();
		RegisterEmployee employeeUserFind = new Jongo(MongoDbUtil.getDB()).getCollection("Employee")
				.findOne("{$or:[{emailId:#},{mobileNo:#}]}", employee.getEmailId(), employee.getMobileNo()).as(RegisterEmployee.class);
		if (employeeUserFind != null) 
		{
			if (employee.getMobileNo() == employeeUserFind.getMobileNo()) 
			{
				statusResponse.setStatusCode(StatusConstants.STATUS_UNSUCCESS_CODE);
				statusResponse.setStatusMessage(StatusConstants.STATUS_MOBILE_EXIST_MESSAGE);
				return statusResponse;
			}
			if (employee.getEmailId().equals(employeeUserFind.getEmailId()))
			{
				statusResponse.setStatusCode(StatusConstants.STATUS_UNSUCCESS_CODE);
			    statusResponse.setStatusMessage(StatusConstants.STATUS_EMAIL_EXIST_MESSAGE);
			    return statusResponse;
			}
		}
		else
		{
			if (employee != null && employee.getEmpId() == 0) 
			{
				String id = "empId";
				new Jongo(MongoDbUtil.getDB()).getCollection("Counters").update("{ _id:# }", id).with("{$inc:{seq:1}}");
				Counters counters = new Jongo(MongoDbUtil.getDB()).getCollection("Counters").findOne("{ _id: #}", id)
						.as(Counters.class);
				employee.setEmpId(counters.getSeq());
			}
			new Jongo(MongoDbUtil.getDB()).getCollection("Employee").insert(employee);
			statusResponse.setStatusCode(StatusConstants.STATUS_SUCCESS_CODE);
			statusResponse.setStatusMessage(StatusConstants.STATUS_REGISTER_MESSAGE);
			return statusResponse;
		}
		return statusResponse;
	}
}
