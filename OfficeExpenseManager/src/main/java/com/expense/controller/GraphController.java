package com.expense.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.expense.service.GraphService;
import com.expense.vo.DateWiseExpenseCollection;

@RestController
@RequestMapping("/graph")
public class GraphController {

	GraphService service = new GraphService();
	@RequestMapping(value = "/graph1", method = RequestMethod.GET)
	public List<DateWiseExpenseCollection> hrExpenseCollectionGraph(long startDate,long endDate) 
	{
		List<DateWiseExpenseCollection> datewise = service.hrExpenseCollectionGraph(startDate,endDate);
		return datewise;
	}
	
	@RequestMapping(value = "/graph2", method = RequestMethod.GET)
	public List<DateWiseExpenseCollection> employeeExpenseCollectionGraph(long empId,long startDate,long endDate) 
	{
		List<DateWiseExpenseCollection> datewise = service.employeeExpenseCollectionGraph(empId,startDate,endDate);
		return datewise;
	}
}
