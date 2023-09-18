package com.ess.ebankgraphql.entity;

import com.ess.ebankgraphql.dto.CustomerDTO;
import com.ess.ebankgraphql.enums.IdentityCardType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String identityCardNumber;

    @Enumerated(EnumType.STRING)
    private IdentityCardType identityCardType;

    private Long contractID;

    private Date createdAt;
    private Date updatedAt;

    public static Customer toCustomer(CustomerDTO customerDTO) {
        return Customer.builder()
                .fullName(customerDTO.getFullName())
                .identityCardNumber(customerDTO.getIdentityCardNumber())
                .identityCardType(customerDTO.getIdentityCardType())
                .build();

    }

    public static CustomerDTO toCustomerDTO(Customer Customer) {
        return CustomerDTO.builder()
                .fullName(Customer.getFullName())
                .identityCardNumber(Customer.getIdentityCardNumber())
                .identityCardType(Customer.getIdentityCardType())
                .build();

    }
}
