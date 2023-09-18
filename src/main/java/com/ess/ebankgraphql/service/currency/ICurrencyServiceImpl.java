package com.ess.ebankgraphql.service.currency;

import com.ess.ebankgraphql.dto.CurrencyDTO;
import com.ess.ebankgraphql.entity.Currency;

import java.util.List;

public class ICurrencyServiceImpl implements ICurrencyService {
    @Override
    public Currency create(CurrencyDTO item) {
        return null;
    }

    @Override
    public Currency update(CurrencyDTO item, Long id) {
        return null;
    }

    @Override
    public Currency remove(CurrencyDTO item) {
        return null;
    }

    @Override
    public void removeMany(List<CurrencyDTO> items) {

    }

    @Override
    public List<CurrencyDTO> findAll() {
        return null;
    }

    @Override
    public CurrencyDTO findByID(Long id) {
        return null;
    }
}
