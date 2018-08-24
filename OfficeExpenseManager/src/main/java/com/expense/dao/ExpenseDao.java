package com.expense.dao;

import org.jongo.Jongo;

import com.expense.constants.StatusConstants;
import com.expense.util.MongoDbUtil;
import com.expense.vo.DateWiseExpenseCollection;
import com.expense.vo.RegisterEmployee;
import com.expense.vo.Purpose;
import com.expense.vo.StatusResponse;
import com.mongodb.WriteResult;

public class ExpenseDao
{
	public StatusResponse addCollection(DateWiseExpenseCollection exp) 
	{
		StatusResponse statusResponse = new StatusResponse();
		WriteResult result = null;
		
		RegisterEmployee employee=new Jongo(MongoDbUtil.getDB()).getCollection("Employee")
				.findOne("{empId:#}", exp.getEmpId()).as(RegisterEmployee.class);
		
		Purpose purpose=new Jongo(MongoDbUtil.getDB()).getCollection("Purpose")
				.findOne("{name:#}", exp.getPurposeName()).as(Purpose.class);
		
		exp.setEmpId(employee.getEmpId());
		exp.setPurposeId(purpose.getPurposeId());
		
		DateWiseExpenseCollection expense = new Jongo(MongoDbUtil.getDB()).getCollection("DateWiseExpenseCollection")
				.findOne("{empId:#,purposeId:#,date:#}", exp.getEmpId(), exp.getPurposeId(), exp.getDate())
				.as(DateWiseExpenseCollection.class);
		if (expense != null) 
		{
			
			result = new Jongo(MongoDbUtil.getDB()).getCollection("DateWiseExpenseCollection")
					.update("{empId:#,purposeId:#,date:#}", exp.getEmpId(), purpose.getPurposeId(), exp.getDate())
					.with("{$inc:{expenseSpent:#,expenseCollect:#}}", exp.getExpenseSpent(), exp.getExpenseCollect());
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
		else
		{	
			result = new Jongo(MongoDbUtil.getDB()).getCollection("DateWiseExpenseCollection").insert(exp);
			if (result.wasAcknowledged()) 
			{
				statusResponse.setStatusCode(StatusConstants.STATUS_SUCCESS_CODE);
				statusResponse.setStatusMessage(StatusConstants.STATUS_INSERT_MESSAGE);
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
	public StatusResponse addExpense(DateWiseExpenseCollection exp) 
	{
		StatusResponse statusResponse = new StatusResponse();
		WriteResult result = null;
		
		RegisterEmployee employee=new Jongo(MongoDbUtil.getDB()).getCollection("Employee")
				.findOne("{empId:#}", exp.getEmpId()).as(RegisterEmployee.class);
		
		Purpose purpose=new Jongo(MongoDbUtil.getDB()).getCollection("Purpose")
				.findOne("{name:#}", exp.getPurposeName()).as(Purpose.class);
		
		exp.setEmpId(employee.getEmpId());
		exp.setPurposeId(purpose.getPurposeId());
		
		DateWiseExpenseCollection expense = new Jongo(MongoDbUtil.getDB()).getCollection("DateWiseExpenseCollection")
				.findOne("{empId:#,purposeId:#,date:#}", exp.getEmpId(), exp.getPurposeId(), exp.getDate())
				.as(DateWiseExpenseCollection.class);
		if (expense != null) 
		{
			
			result = new Jongo(MongoDbUtil.getDB()).getCollection("DateWiseExpenseCollection")
					.update("{empId:#,purposeId:#,date:#}", exp.getEmpId(), purpose.getPurposeId(), exp.getDate())
					.with("{$inc:{expenseSpent:#,expenseCollect:#}}", exp.getExpenseSpent(), exp.getExpenseCollect());

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
		else
		{	
			result = new Jongo(MongoDbUtil.getDB()).getCollection("DateWiseExpenseCollection").insert(exp);
			if (result.wasAcknowledged()) 
			{
				statusResponse.setStatusCode(StatusConstants.STATUS_SUCCESS_CODE);
				statusResponse.setStatusMessage(StatusConstants.STATUS_INSERT_MESSAGE);
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
	
}
