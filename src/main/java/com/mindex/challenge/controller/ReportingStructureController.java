package com.mindex.challenge.controller;

import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
 * Part of Task1
 * This Read REST endpoint is for reporting Structure request
 * 
 */
@RestController
@RequestMapping("reportingStructure")
public class ReportingStructureController {
    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureController.class);

    @Autowired
    private ReportingStructureService reportingStructureService;

    @GetMapping("/{id}")
    public ReportingStructure read(@PathVariable String id) {
        LOG.debug("Total number of direct reporting for employee id [{}]", id);
        return reportingStructureService.read(id);
    }

}
