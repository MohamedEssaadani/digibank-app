package com.ess.ebankgraphql.specifications;

import com.ess.ebankgraphql.entity.Account;
import com.ess.ebankgraphql.entity.Customer;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class AccountSpecification implements Specification<Account> {
    @Override
    public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return null;
    }
}
