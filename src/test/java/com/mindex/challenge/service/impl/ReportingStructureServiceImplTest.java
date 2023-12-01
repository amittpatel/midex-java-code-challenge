package com.mindex.challenge.service.impl;

import com.mindex.challenge.data.ReportingStructure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
/*
 * Part of Task 1
 * Reporting Structure implementation test 
 * Test Case 1: employeeId = "16a596ae-edd3-4847-99fe-c4518e82c86f"  to return NumberOfReports = 4
 * Test Case 2: employeeId = "c0c2293d-16bd-4603-8e08-638a9d18b22c"  to return NumberOfReports = 0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReportingStructureServiceImplTest {

	private String employeeId;
    private String reportingStructureUrl;
    


    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setup() {
        reportingStructureUrl = "http://localhost:" + port + "/reportingStructure/{id}";
        
    }

    
    @Test
    public void testReadReportingStructure_1() {

        // Read checks
    	employeeId = "16a596ae-edd3-4847-99fe-c4518e82c86f";
        ResponseEntity<ReportingStructure> reportingStructure = restTemplate.getForEntity(reportingStructureUrl, 
        		ReportingStructure.class, employeeId);
        assertEquals(HttpStatus.OK, reportingStructure.getStatusCode());
        ReportingStructure result = (ReportingStructure)reportingStructure.getBody();
        assertEquals(4, result.getNumberOfReports());

    }
    
    @Test
    public void testReadReportingStructure_2() {

        // Read checks
    	employeeId = "c0c2293d-16bd-4603-8e08-638a9d18b22c";
        ResponseEntity reportingStructure = restTemplate.getForEntity(reportingStructureUrl, ReportingStructure.class, employeeId);
        assertEquals(HttpStatus.OK, reportingStructure.getStatusCode());
        ReportingStructure result = (ReportingStructure)reportingStructure.getBody();
        assertEquals(0, result.getNumberOfReports());

    }

}
