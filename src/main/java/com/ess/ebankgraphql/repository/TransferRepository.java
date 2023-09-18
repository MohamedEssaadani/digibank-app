package com.ess.ebankgraphql.repository;

import com.ess.ebankgraphql.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<Transfer, Long> {
}
