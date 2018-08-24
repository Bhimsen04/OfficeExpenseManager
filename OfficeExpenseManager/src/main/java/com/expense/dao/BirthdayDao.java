package com.expense.dao;

import java.util.Iterator;

import org.jongo.Jongo;

import com.expense.util.MongoDbUtil;
import com.expense.vo.RegisterEmployee;

public class BirthdayDao 
{

	public Iterator<RegisterEmployee> birthdayFetch() 
	{
		Iterator<RegisterEmployee> employeeItr = null;
		try
		{
			employeeItr= new Jongo(MongoDbUtil.getDB()).getCollection("Employee").find().as(RegisterEmployee.class);
		}
		catch(Exception e)
		{
			System.out.println("exception while db operation");
		}
		return employeeItr;
	}

}
