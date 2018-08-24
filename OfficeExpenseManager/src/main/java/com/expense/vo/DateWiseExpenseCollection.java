package com.expense.vo;

public class DateWiseExpenseCollection {

	private long empId;
	private long date;
	private double expenseCollect;
	private double expenseSpent;
	private String purposeName;
	private long purposeId;
	
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	public double getExpenseCollect() {
		return expenseCollect;
	}
	public void setExpenseCollect(double expenseCollect) {
		this.expenseCollect = expenseCollect;
	}
	public double getExpenseSpent() {
		return expenseSpent;
	}
	public void setExpenseSpent(double expenseSpent) {
		this.expenseSpent = expenseSpent;
	}
	public String getPurposeName() {
		return purposeName;
	}
	public void setPurposeName(String purposeName) {
		this.purposeName = purposeName;
	}
	public long getPurposeId() {
		return purposeId;
	}
	public void setPurposeId(long purposeId) {
		this.purposeId = purposeId;
	}
	
	
}
