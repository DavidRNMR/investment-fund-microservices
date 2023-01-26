package com.investmentfund.service.fund.repository;

import com.investmentfund.service.fund.entity.FundEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FundRepository extends JpaRepository<FundEntity,Long> {

}
