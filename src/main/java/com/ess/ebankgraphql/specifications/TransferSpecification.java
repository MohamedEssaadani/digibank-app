package com.ess.ebankgraphql.specifications;

import com.ess.ebankgraphql.entity.Transfer;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class TransferSpecification implements Specification<Transfer> {
    @Override
    public Predicate toPredicate(Root<Transfer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return null;
    }
}
