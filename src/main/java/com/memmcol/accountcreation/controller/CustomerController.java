package com.memmcol.accountcreation.controller;

import com.memmcol.accountcreation.domain.entity.CustomerNew;
import com.memmcol.accountcreation.service.CustomerReplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerReplicationService service;

    @PostMapping
    public ResponseEntity<CustomerNew> create(@RequestBody CustomerNew dto) {
        CustomerNew saved = service.createCustomer(dto);
        return ResponseEntity.ok(saved);
    }
}
