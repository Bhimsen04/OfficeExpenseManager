package com.expense.service;

import com.expense.dao.MapDao;

public class MapService 
{

	MapDao dao=new MapDao();
	public String getAddress(long empId)
	{
		return dao.getAddress(empId);
	}

}
