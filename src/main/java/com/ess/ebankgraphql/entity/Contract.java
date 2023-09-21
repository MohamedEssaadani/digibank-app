package com.ess.ebankgraphql.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Contract {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contractNumber;
    private String contractTitle;
}
