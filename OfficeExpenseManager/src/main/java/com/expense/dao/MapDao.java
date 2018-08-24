package com.expense.dao;

import org.jongo.Jongo;

import com.expense.util.MongoDbUtil;
import com.expense.vo.RegisterEmployee;

public class MapDao {

	String address="";
	public String getAddress(long empId) 
	{
		try
		{
			RegisterEmployee registration = new Jongo(MongoDbUtil.getDB()).getCollection("Employee")
											.findOne("{empId:#}",empId)
											.as(RegisterEmployee.class);
			//address = registration.getAddress();
		}
		catch(Exception e)
		{
			address = "exception while db operation";
		}
		return address;
	}

}
