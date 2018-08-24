package com.expense.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.expense.service.ExpenseService;
import com.expense.vo.DateWiseExpenseCollection;
import com.expense.vo.StatusResponse;

@RestController
@RequestMapping("/expense")
public class ExpenseController 
{
	ExpenseService service=new ExpenseService();
	
	@RequestMapping( value="/expenseCollect" , method=RequestMethod.POST , headers="Accept=application/json" )
	public StatusResponse addCollection(@RequestBody DateWiseExpenseCollection exp) 
	{
		StatusResponse statusResponse=service.addCollection(exp);
		System.out.println("In ExpenseController StatusMessage :-"+statusResponse.getStatusMessage());
		return statusResponse;
	}
	
	@RequestMapping( value="/expenseSpent" , method=RequestMethod.POST , headers="Accept=application/json" )
	public StatusResponse addExpense(@RequestBody DateWiseExpenseCollection exp) 
	{
		StatusResponse statusResponse=service.addExpense(exp);
		System.out.println("In ExpenseController StatusMessage :-"+statusResponse.getStatusMessage());
		return statusResponse;
	}

}
