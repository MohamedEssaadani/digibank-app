package com.ess.ebankgraphql.repository;

import com.ess.ebankgraphql.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Long> {
}
