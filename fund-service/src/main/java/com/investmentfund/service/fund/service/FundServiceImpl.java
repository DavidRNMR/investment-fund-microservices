package com.investmentfund.service.fund.service;

import com.investmentfund.service.fund.dto.FundDto;
import com.investmentfund.service.fund.entity.FundEntity;
import com.investmentfund.service.fund.exceptions.FundNotFoundException;
import com.investmentfund.service.fund.mapper.FundMapper;
import com.investmentfund.service.fund.repository.FundRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class FundServiceImpl implements FundService{

    private FundMapper mapper;
    private FundRepository repository;


    @Override
    public List<FundDto> findAll() {

        List<FundEntity> fundEntities = repository.findAll();

        return fundEntities.stream().map
                (fundEntity -> mapper.fromFund(fundEntity)).collect(Collectors.toList());
    }

    @Override
    public FundDto findOne(Long id) throws FundNotFoundException {

        FundEntity fundEntity = repository.findById(id).orElseThrow(()-> new FundNotFoundException("fund not found"));
        return mapper.fromFund(fundEntity);
    }

    @Override
    public FundDto addOne(FundDto fundDto) {

        FundEntity fundEntity = mapper.fromDto(fundDto);
        FundEntity saved = repository.save(fundEntity);

        return mapper.fromFund(saved);
    }

    @Override
    public FundDto update(FundDto fundDto) {
        FundEntity fundEntity = mapper.fromDto(fundDto);
        FundEntity saved = repository.save(fundEntity);

        return mapper.fromFund(saved);
    }

    @Override
    public void delete(Long id) throws FundNotFoundException {
        repository.deleteById(id);
    }
}
