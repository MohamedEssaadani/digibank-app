package com.ess.ebankgraphql.dto;

import com.ess.ebankgraphql.enums.IdentityCardType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDTO {
    private Long id;
    private String fullName;
    private String identityCardNumber;
    private IdentityCardType identityCardType;
    private Long contractID;
}
