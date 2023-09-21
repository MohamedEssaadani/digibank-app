package com.ess.ebankgraphql.repository;

import com.ess.ebankgraphql.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByIdentityCardNumber(String identityNumber);
}
