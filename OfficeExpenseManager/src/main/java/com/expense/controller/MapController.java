package com.expense.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.expense.service.MapService;

@RestController
@RequestMapping("/map")
public class MapController 
{

	MapService service= new MapService();
	@RequestMapping(value="/map1",method= RequestMethod.GET)
	public String map(long empId)
	{
		return service.getAddress(empId);
	}
	
}
