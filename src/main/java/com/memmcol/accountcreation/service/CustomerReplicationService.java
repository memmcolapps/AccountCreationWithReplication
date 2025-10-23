package com.memmcol.accountcreation.service;

import com.memmcol.accountcreation.domain.entity.CustomerNew;
import com.memmcol.accountcreation.repository.CustomerNewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class CustomerReplicationService {

    @Autowired
    private CustomerNewRepository customerRepository;

    @Autowired
    private Map<String, JdbcTemplate> businessJdbcTemplates;

    /**
     * Creates a new customer in the consolidated DB
     * and replicates to its respective business unit database.
     */
    @Transactional("consolidatedTxManager")
    public CustomerNew createCustomer(CustomerNew customer) {
        // Step 1: Save in consolidated database
        CustomerNew saved = customerRepository.save(customer);

        // Step 2: Replicate to target BU
        String buId = saved.getBuid();
        JdbcTemplate targetJdbc = businessJdbcTemplates.get(buId);

        if (targetJdbc != null) {
            String sql = """
                    INSERT INTO CustomerNew
                    (AccountNo, booknumber, oldaccountnumber, MeterNo, Surname, FirstName, OtherNames,
                     Address1, Address2, City, State, email, TariffID, ArrearsBalance, Mobile, BUID, StatusCode, rowguid)
                    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                    """;

            targetJdbc.update(sql,
                    saved.getAccountNo(),
                    saved.getBookNumber(),
                    saved.getOldAccountNumber(),
                    saved.getMeterNo(),
                    saved.getSurname(),
                    saved.getFirstName(),
                    saved.getOtherNames(),
                    saved.getAddress1(),
                    saved.getAddress2(),
                    saved.getCity(),
                    saved.getState(),
                    saved.getEmail(),
                    saved.getTariffId(),
                    saved.getArrearsBalance(),
                    saved.getMobile(),
                    saved.getBuid(),
                    saved.getStatusCode(),
                    saved.getRowGuid()
            );

            System.out.println("✅ Replicated customer to BU: " + buId);
        } else {
            System.err.println("⚠️ No JDBC Template found for business unit: " + buId);
        }
        return saved;
    }
}
