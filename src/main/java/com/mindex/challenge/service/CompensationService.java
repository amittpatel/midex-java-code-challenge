package com.mindex.challenge.service;

import com.mindex.challenge.data.Compensation;
/*
 * Part of Task 2
 * Compensation interface
 * 
 */
public interface CompensationService {
	Compensation create(Compensation compensation);
	Compensation read(String employeeId);
}
