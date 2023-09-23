package com.ess.ebankgraphql.API;

import com.ess.ebankgraphql.dto.ContractDTO;
import com.ess.ebankgraphql.service.contract.IContractService;
import lombok.RequiredArgsConstructor;
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
}
