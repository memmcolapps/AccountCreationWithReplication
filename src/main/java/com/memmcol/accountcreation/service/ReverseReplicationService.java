package com.memmcol.accountcreation.service;

/*TODO:
*  1. Move this service to the Business Unit Springboot application.
*  2. Just here to keep
*  ✅ BU Side — ReverseReplicationService
*  This service lives in the BU system (or could be triggered after insert/update).
*/

import com.memmcol.accountcreation.domain.entity.CustomerNew;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class ReverseReplicationService {
    private final RestTemplate restTemplate = new RestTemplate();

    private static final String CONSOLIDATED_REPL_URL = "http://consolidated-host:8080/api/replication/customer";

    public void replicateToConsolidated(CustomerNew customer) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<CustomerNew> entity = new HttpEntity<>(customer, headers);
            ResponseEntity<String> response = restTemplate.postForEntity(CONSOLIDATED_REPL_URL, entity, String.class);

            log.info("🔁 Reverse replication response: {}",  response.getBody());
        } catch (Exception e) {
            log.error("⚠️ Reverse replication failed for customer {}",  customer.getAccountNo());
            e.printStackTrace();
        }
    }
}
