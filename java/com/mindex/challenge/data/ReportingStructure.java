package com.mindex.challenge.data;

import java.util.Objects;
/*
 * Part of Task 1
 * Reporting Structure data file
 * 
 */
public class ReportingStructure {
	
    private Employee employee;
    private int numberOfReports;

    public ReportingStructure(Employee employee, int numberOfReports) {
    	this.employee = employee;
    	this.numberOfReports = numberOfReports;
    }

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getNumberOfReports() {
		return numberOfReports;
	}

	public void setNumberOfReports(int numberOfReports) {
		this.numberOfReports = numberOfReports;
	}

	@Override
	public String toString() {
		return "ReportingStructure [employee=" + employee + ", numberOfReports=" + numberOfReports + ", getEmployee()="
				+ getEmployee() + ", getNumberOfReports()=" + getNumberOfReports() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(employee, numberOfReports);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReportingStructure other = (ReportingStructure) obj;
		return Objects.equals(employee, other.employee) && numberOfReports == other.numberOfReports;
	}
     
    
    
}
