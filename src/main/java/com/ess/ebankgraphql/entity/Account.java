package com.ess.ebankgraphql.entity;

import com.ess.ebankgraphql.dto.AccountDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountNumber;
    private Long currencyID;
    private BigDecimal balance;
    private Long contractID;
    private Date createdAt;
    private Date updatedAt;

    public static Account toAccount(AccountDTO accountDTO) {
        return Account.builder()
                .accountNumber(accountDTO.getAccountNumber())
                .balance(accountDTO.getBalance())
                .currencyID(accountDTO.getCurrencyID()).build();
    }

    public static AccountDTO toAccountDTO(Account account) {
        return AccountDTO.builder()
                .accountNumber(account.getAccountNumber())
                .balance(account.getBalance())
                .currencyID(account.getCurrencyID()).build();
    }

}
