package com.expense.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jongo.Jongo;
import com.expense.util.MongoDbUtil;
import com.expense.vo.DateWiseExpenseCollection;

public class GraphDao
{
	public List<DateWiseExpenseCollection> hrExpenseCollectionGraph(long startDate,long endDate) 
	{
		List<DateWiseExpenseCollection> list=new ArrayList<DateWiseExpenseCollection>();
		Iterator<DateWiseExpenseCollection> allDateWiseEmp1 = new Jongo(MongoDbUtil.getDB()).getCollection("DateWiseExpenseCollection")
				                                   .find("{date:{$lte:#,$gte:#}}", endDate,startDate).as(DateWiseExpenseCollection.class).iterator();
		Iterator<DateWiseExpenseCollection> allDateWiseEmp2 = new Jongo(MongoDbUtil.getDB()).getCollection("DateWiseExpenseCollection").
				                                    find("{date:{$lte:#,$gte:#}}", endDate,startDate).as(DateWiseExpenseCollection.class).iterator();
		Map<Long,Double> dateCounter1=new HashMap<Long,Double>();
		Map<Long,Double> dateCounter2=new HashMap<Long,Double>();

		while(allDateWiseEmp1.hasNext())
		{
			DateWiseExpenseCollection exp=allDateWiseEmp1.next();
			if(exp.getDate()>=startDate && exp.getDate()<=endDate)
				if(dateCounter1.containsKey(exp.getEmpId()))
	                dateCounter1.put(exp.getEmpId(), dateCounter1.get(exp.getEmpId())+exp.getExpenseSpent());
	            else
	                dateCounter1.put(exp.getEmpId(), exp.getExpenseSpent());
		}
		while(allDateWiseEmp2.hasNext())
		{
			DateWiseExpenseCollection exp=allDateWiseEmp2.next();
			if(exp.getDate()>=startDate && exp.getDate()<=endDate)
				if(dateCounter2.containsKey(exp.getEmpId()))
	            	dateCounter2.put(exp.getEmpId(), dateCounter2.get(exp.getEmpId())+exp.getExpenseCollect());
	            else
	            	dateCounter2.put(exp.getEmpId(), exp.getExpenseCollect());
		}
		for(Long key1:dateCounter1.keySet())
        {
			DateWiseExpenseCollection dateWiseExpense=new DateWiseExpenseCollection();
			dateWiseExpense.setEmpId(key1);
			dateWiseExpense.setExpenseSpent(dateCounter1.get(key1));
			for(Long key2:dateCounter2.keySet())
	        {
				if(key1.equals(key2))
					dateWiseExpense.setExpenseCollect(dateCounter2.get(key2));
	        }
			list.add(dateWiseExpense);
        }
		return list;
	}

	public List<DateWiseExpenseCollection> employeeExpenseCollectionGraph(long empId,long startDate,long endDate) 
	{
		
		List<DateWiseExpenseCollection> list=new ArrayList<DateWiseExpenseCollection>();
		Iterator<DateWiseExpenseCollection> allDateWiseEmp = new Jongo(MongoDbUtil.getDB()).getCollection("DateWiseExpenseCollection")
				                                   .find("{date:{$lte:#,$gte:#}}", endDate,startDate).as(DateWiseExpenseCollection.class).iterator();
		Map<Long,Double> dateCounter1=new HashMap<Long,Double>();
		Map<Long,Double> dateCounter2=new HashMap<Long,Double>();

		while(allDateWiseEmp.hasNext())
		{
			DateWiseExpenseCollection exp=allDateWiseEmp.next();
			if(exp.getEmpId()==empId)
	            if(dateCounter1.containsKey(exp.getDate()))
	                dateCounter1.put(exp.getDate(), dateCounter1.get(exp.getDate())+exp.getExpenseSpent());
	            else
	                dateCounter1.put(exp.getDate(), exp.getExpenseSpent());
		}
		
		allDateWiseEmp = new Jongo(MongoDbUtil.getDB()).getCollection("DateWiseExpenseCollection")
                .find("{date:{$lte:#,$gte:#}}", endDate,startDate).as(DateWiseExpenseCollection.class).iterator();
		
		while(allDateWiseEmp.hasNext())
		{
			DateWiseExpenseCollection exp=allDateWiseEmp.next();
			if(exp.getEmpId()==empId)
	            if(dateCounter2.containsKey(exp.getDate()))
	            	dateCounter2.put(exp.getDate(), dateCounter2.get(exp.getDate())+exp.getExpenseCollect());
	            else
	            	dateCounter2.put(exp.getDate(), exp.getExpenseCollect());
		}
		for(Long key1:dateCounter1.keySet())
        {
			DateWiseExpenseCollection dateWiseExpense=new DateWiseExpenseCollection();
			dateWiseExpense.setDate(key1);
			dateWiseExpense.setExpenseSpent(dateCounter1.get(key1));
			for(Long key2:dateCounter2.keySet())
	        {
				if(key1.equals(key2))
					dateWiseExpense.setExpenseCollect(dateCounter2.get(key2));
	        }
			list.add(dateWiseExpense);
        }
		return list;
	}

}
