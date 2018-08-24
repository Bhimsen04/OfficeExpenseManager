package com.expense.service;

import java.util.List;

import com.expense.dao.LoginDao;
import com.expense.vo.RegisterEmployee;
import com.expense.vo.Login;
import com.expense.vo.StatusResponse;

public class LoginService 
{
	
	LoginDao dao=new LoginDao();

	public List<RegisterEmployee> fetchEmployees() 
	{
		return dao.fetchEmployees();
	}
	
	public StatusResponse loginUser(Login login) 
	{
		return dao.loginUser(login);
	}

}
