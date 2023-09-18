package com.ess.ebankgraphql.service.transfer;

import com.ess.ebankgraphql.dto.TransferDTO;
import com.ess.ebankgraphql.entity.Transfer;
import com.ess.ebankgraphql.service.generics.IGenericeService;

public interface ITransferService extends IGenericeService<TransferDTO, Transfer> {
}
