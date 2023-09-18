package com.ess.ebankgraphql.service.account;

import com.ess.ebankgraphql.dto.AccountDTO;
import com.ess.ebankgraphql.dto.CustomerDTO;
import com.ess.ebankgraphql.entity.Account;
import com.ess.ebankgraphql.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class IAccountServiceImpl implements IAccountService {
    private final AccountRepository accountRepository;

    @Override
    public Account create(AccountDTO item) {
        Account account = Account.toAccount(item);

        return accountRepository.save(account);
    }

    @Override
    public Account update(AccountDTO item, Long id) {
        Account account = Account.toAccount(item);
        account.setId(id);
        account.setUpdatedAt(new Date());

        return accountRepository.save(account);
    }

    @Override
    public Account remove(AccountDTO item) {
        Account accountToDelete = Account.toAccount(item);
        accountRepository.delete(accountToDelete);

        return accountToDelete;
    }

    @Override
    public void removeMany(List<AccountDTO> items) {
        // find ids for accounts to be deleted
        List<Long> ids = items.stream()
                .map(AccountDTO::getId)
                .collect(Collectors.toList());

        // delete accounts
        accountRepository.deleteAllById(ids);
    }

    @Override
    public List<AccountDTO> findAll() {
        return accountRepository.findAll()
                .stream().map(Account::toAccountDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AccountDTO findByID(Long id) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        AccountDTO accountDTO = new AccountDTO();

        if (optionalAccount.isPresent()) {
            accountDTO = Account.toAccountDTO(optionalAccount.get());
        }
        return accountDTO;
    }
}
