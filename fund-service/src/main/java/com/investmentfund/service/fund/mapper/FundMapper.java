package com.investmentfund.service.fund.mapper;

import com.investmentfund.service.fund.dto.FundDto;
import com.investmentfund.service.fund.entity.FundEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class FundMapper {

    public FundDto fromFund (FundEntity fundEntity){

        FundDto fundDto = new FundDto();
        BeanUtils.copyProperties(fundEntity,fundDto);
        return  fundDto;
    }

    public FundEntity fromDto (FundDto fundDto){

        FundEntity fundEntity = new FundEntity();
        BeanUtils.copyProperties(fundDto,fundEntity);
        return fundEntity;
    }
}
