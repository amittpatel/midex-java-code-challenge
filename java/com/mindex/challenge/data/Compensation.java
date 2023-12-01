package com.mindex.challenge.data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
/*
 * Part of Task 2
 * Compensation data file
 * 
 */

public class Compensation {
	
    private Employee employee;
    private BigDecimal salary;
    private Date effectiveDate;
    
    public Compensation(Employee employee, BigDecimal salary, Date effectiveDate) {
    	this.employee = employee;
    	this.salary = salary;
    	this.effectiveDate = effectiveDate;
    }
    
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	@Override
	public String toString() {
		return "Compensation [employee=" + employee + ", salary=" + salary + ", effectiveDate=" + effectiveDate
				+ ", getEmployee()=" + getEmployee() + ", getSalary()=" + getSalary() + ", getEffectiveDate()="
				+ getEffectiveDate() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(effectiveDate, employee, salary);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compensation other = (Compensation) obj;
		return Objects.equals(effectiveDate, other.effectiveDate) && Objects.equals(employee, other.employee)
				&& Objects.equals(salary, other.salary);
	}
     
    
}
