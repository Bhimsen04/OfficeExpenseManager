package com.expense.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import com.expense.dao.AnniversaryDao;
import com.expense.vo.AnniversaryList;
import com.expense.vo.RegisterEmployee;

public class AnniversaryService 
{

	AnniversaryDao dao = new AnniversaryDao();
	public List<AnniversaryList> empAnniversaryFetch() throws Exception 
	{
		Iterator<RegisterEmployee> itr = dao.empAnniversaryFetch();
		List<AnniversaryList> list = new ArrayList<AnniversaryList>();
		try 
		{
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(System.currentTimeMillis());
			while (itr.hasNext()) 
			{
				AnniversaryList empAnniversary = new AnniversaryList();
				RegisterEmployee employee = itr.next();
				Calendar dbCalendar = Calendar.getInstance();
				dbCalendar.setTimeInMillis(employee.getJoiningDay());
				dbCalendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
				long difference = dbCalendar.getTimeInMillis() - calendar.getTimeInMillis();
				if (difference >=-86400000 && difference <= 604800000) 
				{
					empAnniversary.setEmpName(employee.getName());
					empAnniversary.setEmailId(employee.getEmailId());
					if(difference>=-86400000 && difference<=0)
						empAnniversary.setDaysLeft(0);
					else if (difference <= 86400000)
						empAnniversary.setDaysLeft(1);
					else if (difference > 86400000 && difference <= 172800000)
						empAnniversary.setDaysLeft(2);
					else if (difference > 172800000 && difference <= 259200000)
						empAnniversary.setDaysLeft(3);
					else if (difference > 259200000 && difference <= 345600000)
						empAnniversary.setDaysLeft(4);
					else if (difference > 345600000 && difference <= 432000000)
						empAnniversary.setDaysLeft(5);
					else if (difference > 432000000 && difference <= 518400000)
						empAnniversary.setDaysLeft(6);
					else if (difference > 518400000 && difference <= 604800000)
						empAnniversary.setDaysLeft(7);
					list.add(empAnniversary);
				}
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("exception:::" + e);
		}
		return list;
	}

}
