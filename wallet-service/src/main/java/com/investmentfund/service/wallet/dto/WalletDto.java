package com.investmentfund.service.wallet.dto;

import com.investmentfund.service.wallet.enums.WalletStatus;
import lombok.Data;

import java.io.Serializable;

@Data
public class WalletDto implements Serializable {

    private Long id;
    private Float balance;
    private WalletStatus walletStatus;
}
