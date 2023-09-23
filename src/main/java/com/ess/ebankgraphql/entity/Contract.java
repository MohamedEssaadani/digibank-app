package com.ess.ebankgraphql.entity;

import com.ess.ebankgraphql.dto.ContractDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String contractNumber;
    private String contractTitle;
    private Date createdAt;

    public static Contract toContract(ContractDTO contractDTO) {
        return Contract.builder()
                .contractNumber(contractDTO.getContractNumber())
                .contractTitle(contractDTO.getContractTitle())
                .build();
    }

    public static ContractDTO toContractDTO(Contract contract){
        return ContractDTO.builder()
                .contractNumber(contract.getContractNumber())
                .contractTitle(contract.getContractTitle())
                .build();
    }
}
