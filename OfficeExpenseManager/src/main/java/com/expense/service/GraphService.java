package com.expense.service;

import java.util.List;

import com.expense.dao.GraphDao;
import com.expense.vo.DateWiseExpenseCollection;

public class GraphService 
{

	GraphDao dao=new GraphDao();

	public List<DateWiseExpenseCollection> hrExpenseCollectionGraph(long startDate,long endDate) 
	{
		return dao.hrExpenseCollectionGraph(startDate,endDate);
	}
	
	public List<DateWiseExpenseCollection> employeeExpenseCollectionGraph(long empId,long startDate,long endDate) 
	{
		return dao.employeeExpenseCollectionGraph(empId,startDate,endDate);
	}
	
}
