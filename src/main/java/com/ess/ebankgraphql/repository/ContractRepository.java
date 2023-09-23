package com.ess.ebankgraphql.repository;

import com.ess.ebankgraphql.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContractRepository extends JpaRepository<Contract, Long> {
    Contract findByContractNumber(String contractNumber);

    Contract findByContractTitle(String contractTitle);

    @Query("SELECT c FROM Contract c WHERE c.contractNumber = :number OR c.contractTitle = :title")
    Contract findByTitleOrNumber(String title, String number);
}
