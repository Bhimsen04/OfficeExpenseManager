package com.expense.dao;

import org.jongo.Jongo;

import com.expense.constants.StatusConstants;
import com.expense.util.MongoDbUtil;
import com.expense.vo.RegisterEmployee;
import com.expense.vo.StatusResponse;
import com.mongodb.WriteResult;

public class UpdateDao
{
	public StatusResponse update(RegisterEmployee employee) 
	{
		StatusResponse statusResponse = new StatusResponse();
		WriteResult result = new Jongo(MongoDbUtil.getDB()).getCollection("Employee")
				.update("{empId:#}", employee.getEmpId()).upsert().with(employee);
		if (result.wasAcknowledged()) 
		{
			statusResponse.setStatusCode(StatusConstants.STATUS_SUCCESS_CODE);
			statusResponse.setStatusMessage(StatusConstants.STATUS_UPDATE_MESSAGE);
			return statusResponse;
		}
		else 
		{
			statusResponse.setStatusCode(StatusConstants.STATUS_UNSUCCESS_CODE);
			statusResponse.setStatusMessage(StatusConstants.STATUS_FAILED_MESSAGE);
			return statusResponse;
		}
		
	}
}
