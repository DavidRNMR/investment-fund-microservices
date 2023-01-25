package com.investmentfund.service.wallet.repository;

import com.investmentfund.service.wallet.entity.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<WalletEntity,Long> {

    WalletEntity findByUserId (Long userId);
}
