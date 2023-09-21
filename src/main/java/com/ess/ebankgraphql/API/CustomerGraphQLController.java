package com.ess.ebankgraphql.API;

import com.ess.ebankgraphql.dto.CustomerDTO;
import com.ess.ebankgraphql.service.customer.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class CustomerGraphQLController {
    private final ICustomerService customerService;

    @QueryMapping
    public List<CustomerDTO> getCustomersList() {
        return customerService.findAll();
    }

    @QueryMapping
    public CustomerDTO getCustomerById(@Argument String id) {
        return customerService.findByID(Long.valueOf(id));
    }

    @QueryMapping
    public CustomerDTO getCustomerByIdentityNumber(@Argument String identityNumber) {
        return customerService.findByIdentityNumber(identityNumber);
    }

    // search customers by many conditions
}
