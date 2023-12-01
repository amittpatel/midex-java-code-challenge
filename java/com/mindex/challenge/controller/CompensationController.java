package com.mindex.challenge.controller;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
 * Part of Task 2
 * These Create and Read REST endpoints are for Compensation request
 * 
 */
@RestController
@RequestMapping("compensation")
public class CompensationController {
    private static final Logger LOG = LoggerFactory.getLogger(CompensationController.class);

    @Autowired
    private CompensationService compensationService;

    @PostMapping
    public Compensation create(@RequestBody Compensation compensation) {
        LOG.debug("Received to create a new compensation request for [{}]", compensation);
        return compensationService.create(compensation);
    }

    @GetMapping("/{id}")
    public Compensation read(@PathVariable String id) {
        LOG.debug("Received request to read compensation for employeeId [{}]", id);
        return compensationService.read(id);
    }

}
