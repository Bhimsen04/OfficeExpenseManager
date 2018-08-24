package com.expense.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.expense.service.BirthdayService;
import com.expense.vo.Birthdaylist;

@RestController
@RequestMapping("/birthday")
public class BirthdayController {

	BirthdayService service = new BirthdayService();
	List<Birthdaylist> bdayList = new ArrayList<Birthdaylist>();

	@RequestMapping(value = "/birthday1", method = RequestMethod.GET)
	public List<Birthdaylist> birthdayFetch() throws Exception 
	{
		try
		{
			bdayList = service.birthdayFetch();
		} 
		catch (Exception e) 
		{
			
		}
		return bdayList;
	}

}
