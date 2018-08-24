package com.expense.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.expense.service.AnniversaryService;
import com.expense.vo.AnniversaryList;

@RestController
@RequestMapping("/employeeAnniversary")
public class AnniversaryController 
{

	AnniversaryService service = new AnniversaryService();
	List<AnniversaryList> anniversaryList = new ArrayList<AnniversaryList>();

	@RequestMapping(value = "/employeeAnniversary1", method = RequestMethod.GET)
	public List<AnniversaryList> empAnniversaryFetch() throws Exception 
	{
		try 
		{
			anniversaryList = service.empAnniversaryFetch();
		} 
		catch (Exception e)
		{
		}
		return anniversaryList;
	}
}
