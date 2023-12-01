package com.mindex.challenge.service.impl;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.CompensationService;
import com.mindex.challenge.service.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.Date;
/*
 * Part of Task 2
 * CompensationService implementation test 
 * Test case 1: To create new Compensation with some value and verify create works
 * Test case 2: To read newly created Compensation
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CompensationServiceImplTest {

	private String employeeId;
	
    private String newCompensationUrl;
    private String readCompensationUrl;

    @Autowired
    private EmployeeService  employeeService;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setup() {
        newCompensationUrl = "http://localhost:" + port + "/compensation";
        readCompensationUrl = "http://localhost:" + port + "/compensation/{id}";
        
    }

    @Test
    public void testCreateReadCompensation() {
    	employeeId = "16a596ae-edd3-4847-99fe-c4518e82c86f";
    	BigDecimal salary = new BigDecimal("100000"); 
        Employee employee = employeeService.read(employeeId);
        Compensation compensation = new Compensation(employee, salary, new Date());


        // Create checks
        ResponseEntity compensationResponse = restTemplate.postForEntity(newCompensationUrl, compensation, Compensation.class);
        
        assertEquals(HttpStatus.OK, compensationResponse.getStatusCode());
        Compensation newCompensation = (Compensation) compensationResponse.getBody();

        assertNotNull(newCompensation);
        assertEquals(compensation.getEmployee().getEmployeeId(), newCompensation.getEmployee().getEmployeeId());
        assertEquals(compensation.getSalary(), newCompensation.getSalary());
        assertEquals(compensation.getEffectiveDate(), newCompensation.getEffectiveDate());

        
        
        // Read checks
        ResponseEntity readcompensation = restTemplate.getForEntity(readCompensationUrl, Compensation.class, employeeId);
        assertEquals(HttpStatus.OK, readcompensation.getStatusCode());
        Compensation readCompensation = (Compensation) readcompensation.getBody();
        assertNotNull(readCompensation);
        assertEquals(compensation.getEmployee().getEmployeeId(), readCompensation.getEmployee().getEmployeeId());
        assertEquals(compensation.getSalary(), readCompensation.getSalary());
        assertEquals(compensation.getEffectiveDate(), readCompensation.getEffectiveDate());


    }



}
