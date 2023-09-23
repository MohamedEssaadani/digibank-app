package com.ess.ebankgraphql.API;

import com.ess.ebankgraphql.dto.ContractDTO;
import com.ess.ebankgraphql.entity.Contract;
import com.ess.ebankgraphql.service.contract.IContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ContractGraphQLController {
    private final IContractService contractService;

    @QueryMapping
    public List<ContractDTO> getContractsList() {
        return contractService.findAll();
    }

    @QueryMapping
    public ContractDTO getContractByNumber(@Argument String contractNumber) {
        return contractService.findByContractNumber(contractNumber);
    }

    @QueryMapping
    public ContractDTO getContractByTitle(@Argument String contractTitle) {
        return contractService.findByContractTitle(contractTitle);
    }

    @MutationMapping
    public ContractDTO createContract(@Argument ContractDTO contractDTO) {
        Contract contract = contractService.create(contractDTO);
        return Contract.toContractDTO(contract);
    }

    // search contract by many conditions
}
