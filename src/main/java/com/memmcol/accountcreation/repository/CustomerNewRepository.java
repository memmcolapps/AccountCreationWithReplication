package com.memmcol.accountcreation.repository;

import com.memmcol.accountcreation.domain.entity.CustomerNew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerNewRepository extends JpaRepository<CustomerNew, String> {
    Optional<CustomerNew> findByAccountNo(String accountNo);
}
