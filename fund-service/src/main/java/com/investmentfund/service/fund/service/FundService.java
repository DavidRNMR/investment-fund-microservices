package com.investmentfund.service.fund.service;

import com.investmentfund.service.fund.dto.FundDto;
import com.investmentfund.service.fund.exceptions.FundNotFoundException;

import java.util.List;

public interface FundService {

    List<FundDto> findAll();
    FundDto findOne (Long id) throws FundNotFoundException;
    FundDto addOne (FundDto fundDto);
    FundDto update (FundDto fundDto);
    void delete (Long id) throws FundNotFoundException;
}
