package com.expense.service;

import com.expense.dao.DeleteDao;
import com.expense.vo.StatusResponse;

public class DeleteService 
{
	DeleteDao dao=new DeleteDao();
	
	public StatusResponse delete(long empId)
	{
		return dao.delete(empId);
	}

}
