package com.ess.ebankgraphql.repository;

import com.ess.ebankgraphql.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
}
