package com.ess.ebankgraphql.service.transfer;

import com.ess.ebankgraphql.dto.TransferDTO;
import com.ess.ebankgraphql.entity.Transfer;

import java.util.List;

public class ITransferServiceImpl implements ITransferService {
    @Override
    public Transfer create(TransferDTO item) {
        return null;
    }

    @Override
    public Transfer update(TransferDTO item, Long id) {
        return null;
    }

    @Override
    public Transfer remove(TransferDTO item) {
        return null;
    }

    @Override
    public void removeMany(List<TransferDTO> items) {

    }

    @Override
    public List<TransferDTO> findAll() {
        return null;
    }

    @Override
    public TransferDTO findByID(Long id) {
        return null;
    }
}
