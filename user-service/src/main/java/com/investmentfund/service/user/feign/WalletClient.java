package com.investmentfund.service.user.feign;

import com.investmentfund.service.user.models.Wallet;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "wallet-service")
public interface WalletClient {


    @GetMapping("/walletByUser/{userId}")
    Wallet findUserWallet(@PathVariable Long userId);

    @PostMapping("/wallets")
    Wallet addWallet (Wallet wallet);
}
