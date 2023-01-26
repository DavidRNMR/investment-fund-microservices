package com.investmentfund.service.fund.dto;

import com.investmentfund.service.fund.enums.FundType;
import lombok.Data;

import java.io.Serializable;

@Data
public class FundDto implements Serializable {

    private Long id;
    private String name;
    private FundType type;
}
