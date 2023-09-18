package com.ess.ebankgraphql.specifications;

import com.ess.ebankgraphql.entity.Transfer;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class TransferSpecification implements Specification<Transfer> {
    @Override
    public Predicate toPredicate(Root<Transfer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return null;
    }
}
