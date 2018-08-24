package com.expense.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import com.expense.dao.BirthdayDao;
import com.expense.vo.Birthdaylist;
import com.expense.vo.RegisterEmployee;

public class BirthdayService 
{
	BirthdayDao dao = new BirthdayDao();

	public List<Birthdaylist> birthdayFetch() throws Exception
	{
		Iterator<RegisterEmployee> employeeItr = dao.birthdayFetch();
		List<Birthdaylist> bdayList = new ArrayList<Birthdaylist>();
		try
		{
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(System.currentTimeMillis());
			while (employeeItr.hasNext())
			{
				Birthdaylist bday = new Birthdaylist();
				RegisterEmployee employee = employeeItr.next();
				Calendar dbCalendar = Calendar.getInstance();
				dbCalendar.setTimeInMillis(employee.getBirthday());
				dbCalendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
				long difference = dbCalendar.getTimeInMillis() - calendar.getTimeInMillis();
				if (difference >=-86400000 && difference <= 604800000) 
				{
					bday.setEmpName(employee.getName());
					bday.setEmailId(employee.getEmailId());
					if(difference>=-86400000 && difference<=0)
						bday.setDaysLeft(0);
					else if (difference <= 86400000)
						bday.setDaysLeft(1);
					else if (difference > 86400000 && difference <= 172800000)
						bday.setDaysLeft(2);
					else if (difference > 172800000 && difference <= 259200000)
						bday.setDaysLeft(3);
					else if (difference > 259200000 && difference <= 345600000)
						bday.setDaysLeft(4);
					else if (difference > 345600000 && difference <= 432000000)
						bday.setDaysLeft(5);
					else if (difference > 432000000 && difference <= 518400000)
						bday.setDaysLeft(6);
					else if (difference > 518400000 && difference <= 604800000)
						bday.setDaysLeft(7);
					bdayList.add(bday);
				}
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("exception:::" + e);
		}
		return bdayList;
	}

}
