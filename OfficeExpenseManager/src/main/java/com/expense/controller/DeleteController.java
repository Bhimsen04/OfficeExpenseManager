package com.expense.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.expense.service.DeleteService;
import com.expense.vo.StatusResponse;

@RestController
@RequestMapping("/delete")
public class DeleteController 
{
	
	DeleteService service=new DeleteService();
	
	@RequestMapping( value="/delete1" , method=RequestMethod.GET )
	public StatusResponse delete(long empId)
	{
		return service.delete(empId);
	}

}
