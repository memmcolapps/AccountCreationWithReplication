package com.memmcol.accountcreation.controller;

import com.memmcol.accountcreation.domain.entity.CustomerNew;
import com.memmcol.accountcreation.repository.CustomerNewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/replication")
public class ReverseReplicationController {
    @Autowired
    private CustomerNewRepository customerRepository;

    /**
     * Endpoint to receive replicated customer records from BU systems.
     */
    @PostMapping("/customer")
    public String replicateFromBU(@RequestBody CustomerNew incoming) {
        Optional<CustomerNew> existing = customerRepository.findByAccountNo(incoming.getAccountNo());

        if (existing.isPresent()) {
            // Update existing customer
            CustomerNew existingCustomer = existing.get();
            existingCustomer.setSurname(incoming.getSurname());
            existingCustomer.setFirstName(incoming.getFirstName());
            existingCustomer.setAddress1(incoming.getAddress1());
            existingCustomer.setCity(incoming.getCity());
            existingCustomer.setState(incoming.getState());
            existingCustomer.setEmail(incoming.getEmail());
            existingCustomer.setMobile(incoming.getMobile());
            existingCustomer.setTariffId(incoming.getTariffId());
            customerRepository.save(existingCustomer);

            return "✅ Updated existing customer in consolidated DB.";
        } else {
            // Insert new customer
            customerRepository.save(incoming);
            return "✅ New customer replicated into consolidated DB.";
        }
    }
}
