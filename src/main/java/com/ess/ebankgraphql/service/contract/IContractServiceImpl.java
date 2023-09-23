package com.ess.ebankgraphql.service.contract;

import com.ess.ebankgraphql.dto.ContractDTO;
import com.ess.ebankgraphql.entity.Contract;
import com.ess.ebankgraphql.repository.ContractRepository;
import com.ess.ebankgraphql.utils.Constante;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class IContractServiceImpl implements IContractService {
    private final ContractRepository repository;

    @Override
    public Contract create(ContractDTO item) {
        // validate contract DTO
        validateContractCreationRequest(item);

        Contract contract = Contract.toContract(item);
        contract.setCreatedAt(new Date());

        return repository.save(contract);
    }

    /**
     * @param item: Contract DTO for creation to validate
     */
    private void validateContractCreationRequest(ContractDTO item) {
        // control for unique contract number & title
        if (contractExists(item))
            throw new RuntimeException(Constante.ERROR_CONTRACT_EXISTS);

        // control for request data is valid
        if (!contractValidated(item)) {
            log.error(Constante.ERROR_CONTRACT_NOT_VALID);
            throw new RuntimeException(Constante.ERROR_CONTRACT_NOT_VALID);
        }
    }

    /**
     * @param item
     * @return
     */
    private boolean contractValidated(ContractDTO item) {
        String contractNumber = item.getContractNumber();
        boolean isNumber = true;
        boolean isValid = true;

        try {
            double d = Double.parseDouble(contractNumber);
        } catch (NumberFormatException nfe) {
            isNumber = false;
        }

        if (!isNumber) {
            log.error(Constante.ERROR_CONTRACT_NUMBER);
            isValid = false;
        }

        return isValid;
    }

    /**
     * @param contractDTO
     * @return
     */
    private boolean contractExists(ContractDTO contractDTO) {
        Contract contract = repository.findByTitleOrNumber(
                contractDTO.getContractTitle(),
                contractDTO.getContractNumber()
        );

        return contract != null;
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

    @Override
    public ContractDTO findByContractNumber(String contractNumber) {
        Contract contract = repository.findByContractNumber(contractNumber);

        return Contract.toContractDTO(contract);
    }

    @Override
    public ContractDTO findByContractTitle(String contractTitle) {
        Contract contract = repository.findByContractTitle(contractTitle);

        return Contract.toContractDTO(contract);
    }
}
