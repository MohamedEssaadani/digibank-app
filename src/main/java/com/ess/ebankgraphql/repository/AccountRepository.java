package com.ess.ebankgraphql.repository;

import com.ess.ebankgraphql.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
