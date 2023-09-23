package com.ess.ebankgraphql.utils;

import com.ess.ebankgraphql.dto.ContractDTO;
import com.ess.ebankgraphql.dto.CustomerDTO;
import com.ess.ebankgraphql.entity.Contract;
import com.ess.ebankgraphql.enums.IdentityCardType;
import com.ess.ebankgraphql.service.contract.IContractService;
import com.ess.ebankgraphql.service.customer.ICustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
@Slf4j
public class Utilities {
    private final ICustomerService customerService;
    private final IContractService contractService;
    private final String[] contracts = {"22829737", "12398973", "98278711", "33229867"};

    public void fillCustomers() {

        Random random = new Random();

        Stream.of("AE9878", "MM22OO", "AA123", "SS232")
                .forEach(cardNumber -> {
                    CustomerDTO customer = CustomerDTO.builder()
                            .fullName("Name " + cardNumber)
                            .identityCardNumber(cardNumber)
                            .identityCardType(IdentityCardType.CNI)
                            .build();

                    customerService.create(customer);
                });
    }

    public void fillContracts() {
        Stream.of(contracts)
                .forEach(contractNumber -> {
                    ContractDTO contract = ContractDTO.builder()
                            .contractNumber(contractNumber)
                            .contractTitle("Title " + contractNumber)
                            .build();

                    contractService.create(contract);
                });
    }

    public void fillAccounts() {

    }
}
