package com.expense.service;

import com.expense.dao.UpdateDao;
import com.expense.vo.RegisterEmployee;
import com.expense.vo.StatusResponse;

public class UpdateService 
{

	UpdateDao dao=new UpdateDao();

	public StatusResponse update(RegisterEmployee employee) 
	{
		return dao.update(employee);
	}
	
}
