package com.investmentfund.service.fund.entity;

import com.investmentfund.service.fund.enums.FundType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="funds")
public class FundEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="FUND_NAME")
    private String name;
    @Enumerated
    @Column(name="FUND_TYPE")
    private FundType type;
}
