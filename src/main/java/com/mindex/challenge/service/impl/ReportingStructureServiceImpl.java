package com.mindex.challenge.service.impl;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.service.ReportingStructureService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * Part of Task 1
 * Reporting Structure implementation
 * 
 */
@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureServiceImpl.class);

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ReportingStructureService reportingStructureService;


    @Override
    public ReportingStructure read(String employeeId) {
    	Employee employee = employeeService.read(employeeId);
        LOG.debug("Computing total number of employees reporint to  employee id [{}] and employee name [{}] ", employeeId, employee);
        // Separate reporting calculation logic into private method
        int reportingSize = calculateDirectReports(employee).size();
        ReportingStructure reportingStructure = new ReportingStructure(employee, reportingSize);
        return reportingStructure;
    }
    
    /*
     * Using recursion to cover deep search for indirect employee report to given employee.
     * At this point i cannot avoid to use recursion
     * create Map of directreport employee ids and stored in set to avoid duplication
     * Loop through direct reports employee ids to find indirect report using recursion
     * return all direct and indirect report employees ids back.
     *
     */
    private Set<String> calculateDirectReports (Employee employee) {
    	Set<String> directReports = new HashSet<>();
    	if (employee.getDirectReports() != null) {
    		directReports = employee.getDirectReports().stream().map(Employee::getEmployeeId).collect(Collectors.toSet());
    		if (!directReports.isEmpty()) {
    			Set<String> inDirectReports = new HashSet<>();
        		for (String employeeId : directReports) {
        			Employee inDirectEmployee = employeeService.read(employeeId);
        			// This will avoid unnecessary call to calculateDirectReports() 
        			if (inDirectEmployee.getDirectReports() != null) {
        				inDirectReports.addAll(calculateDirectReports(inDirectEmployee));
        			}
        		}
        		if (!inDirectReports.isEmpty()) {
        			directReports.addAll(inDirectReports);
        		}
    		}
    	}	
    	return directReports;
    	
    }

}
