package com.ess.ebankgraphql.service.generics;

import com.ess.ebankgraphql.entity.Customer;

import java.util.List;

public interface IGenericeService<T, E> {
    E create(T item);

    E update(T item, Long id);

    E remove(T item);

    void removeMany(List<T> items);

    List<T> findAll();

    T findByID(Long id);
}
