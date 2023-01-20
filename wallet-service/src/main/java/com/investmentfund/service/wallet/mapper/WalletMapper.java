package com.investmentfund.service.wallet.mapper;

import com.investmentfund.service.wallet.dto.WalletDto;
import com.investmentfund.service.wallet.entity.WalletEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class WalletMapper {

    public WalletDto fromWallet (WalletEntity walletEntity){

        WalletDto walletDto = new WalletDto();
        BeanUtils.copyProperties(walletEntity,walletDto);

        return walletDto;
    }

    public WalletEntity fromWalletDto (WalletDto walletDto){

        WalletEntity walletEntity = new WalletEntity();
        BeanUtils.copyProperties(walletDto,walletEntity);

        return walletEntity;
    }
}
