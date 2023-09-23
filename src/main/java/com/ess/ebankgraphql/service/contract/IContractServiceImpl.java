package com.ess.ebankgraphql.service.contract;

import com.ess.ebankgraphql.dto.ContractDTO;
import com.ess.ebankgraphql.entity.Contract;
import com.ess.ebankgraphql.repository.ContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IContractServiceImpl implements IContractService {
    private final ContractRepository repository;

    @Override
    public Contract create(ContractDTO item) {
        Contract contract = Contract.toContract(item);
        contract.setCreatedAt(new Date());

        return repository.save(contract);
    }

    @Override
    public Contract update(ContractDTO item, Long id) {
        return null;
    }

    @Override
    public Contract remove(ContractDTO item) {
        return null;
    }

    @Override
    public void removeMany(List<ContractDTO> items) {

    }

    @Override
    public List<ContractDTO> findAll() {
        return repository.findAll()
                .stream().map(Contract::toContractDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ContractDTO findByID(Long id) {
        return null;
    }
}
