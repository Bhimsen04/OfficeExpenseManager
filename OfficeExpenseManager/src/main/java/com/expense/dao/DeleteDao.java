package com.expense.dao;

import org.jongo.Jongo;
import com.expense.constants.StatusConstants;
import com.expense.util.MongoDbUtil;
import com.expense.vo.StatusResponse;
import com.mongodb.WriteResult;

public class DeleteDao 
{
	
	public StatusResponse delete(long empId)
	{
		StatusResponse statusResponse = new StatusResponse();
		WriteResult result = new Jongo(MongoDbUtil.getDB()).getCollection("Employee").remove("{empId:#}",empId);
		if(result.getN() > 0)
		{
			statusResponse.setStatusCode(StatusConstants.STATUS_UNSUCCESS_CODE);
			statusResponse.setStatusMessage(StatusConstants.STATUS_DELETE_MESSAGE);
			return statusResponse;
		} 
		else 
		{
			statusResponse.setStatusCode(StatusConstants.STATUS_SUCCESS_CODE);
			statusResponse.setStatusMessage(StatusConstants.STATUS_FAILED_MESSAGE);
			return statusResponse;
		}
	}

}
