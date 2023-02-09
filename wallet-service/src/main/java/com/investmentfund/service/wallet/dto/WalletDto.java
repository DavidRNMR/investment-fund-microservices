package com.investmentfund.service.wallet.dto;

import com.investmentfund.service.wallet.enums.WalletStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WalletDto implements Serializable {

    private Long id;
    private Float balance;
    private Long userId;
}
