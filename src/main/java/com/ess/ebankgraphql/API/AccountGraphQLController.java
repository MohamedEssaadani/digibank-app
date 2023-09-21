package com.ess.ebankgraphql.API;

import com.ess.ebankgraphql.dto.AccountDTO;
import com.ess.ebankgraphql.service.account.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AccountGraphQLController {
    private final IAccountService accountService;

    @QueryMapping
    public List<AccountDTO> getAccountsList() {
        return accountService.findAll();
    }
}
