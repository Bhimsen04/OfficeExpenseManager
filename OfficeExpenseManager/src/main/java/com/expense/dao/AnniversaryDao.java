package com.expense.dao;

import java.util.Iterator;

import org.jongo.Jongo;

import com.expense.util.MongoDbUtil;
import com.expense.vo.RegisterEmployee;

public class AnniversaryDao 
{

	public Iterator<RegisterEmployee> empAnniversaryFetch() 
	{
		Iterator<RegisterEmployee> itr = null;
		try
		{
			itr = new Jongo(MongoDbUtil.getDB()).getCollection("Employee").find().as(RegisterEmployee.class);
		} 
		catch (Exception e) 
		{
			System.out.println("exception while db operation");
		}
		return itr;
	}
}
