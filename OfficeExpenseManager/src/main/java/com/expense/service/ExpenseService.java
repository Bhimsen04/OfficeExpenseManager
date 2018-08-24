package com.expense.service;

import com.expense.dao.ExpenseDao;
import com.expense.vo.DateWiseExpenseCollection;
import com.expense.vo.StatusResponse;

public class ExpenseService 
{
	ExpenseDao dao = new ExpenseDao();
	
	public StatusResponse addCollection(DateWiseExpenseCollection exp) 
	{
		return dao.addCollection(exp);
	}
	
	public StatusResponse addExpense(DateWiseExpenseCollection exp) 
	{
		return dao.addExpense(exp);
	}
	
	
}