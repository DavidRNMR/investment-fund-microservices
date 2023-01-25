package com.investmentfund.service.wallet.service;

import com.investmentfund.service.wallet.dto.WalletDto;
import com.investmentfund.service.wallet.exceptions.WalletNotFoundException;

import java.util.List;

public interface WalletService {

    WalletDto saveWallet (WalletDto walletDto);
    WalletDto findOne(Long id) throws WalletNotFoundException;
    void delete (Long id);
    List<WalletDto> findAllWallets();
    WalletDto updateOne(WalletDto walletDto);
    WalletDto findByUser (Long userId);
    void transfer(Long id, Float amount) throws WalletNotFoundException;

}
