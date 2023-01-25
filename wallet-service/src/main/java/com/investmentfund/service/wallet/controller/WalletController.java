package com.investmentfund.service.wallet.controller;

import com.investmentfund.service.wallet.dto.WalletDto;
import com.investmentfund.service.wallet.exceptions.WalletNotFoundException;
import com.investmentfund.service.wallet.service.WalletService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class WalletController {

    private WalletService service;

    @GetMapping("/wallets")
    public List<WalletDto> findWallets(){
        return service.findAllWallets();
    }

    @GetMapping("/wallets/{id}")
    public WalletDto findWallet(@PathVariable Long id) throws WalletNotFoundException {
        return service.findOne(id);
    }

    @PostMapping("/wallets")
    public WalletDto addWallet (@RequestBody WalletDto walletDto){
        return service.saveWallet(walletDto);
    }

    @DeleteMapping("/wallets/{id}")
    public void deleteOne (@PathVariable Long id){
        service.delete(id);
    }

    @PutMapping("/wallets/{id}")
    public WalletDto updateOne (@RequestBody WalletDto walletDto, @PathVariable Long id){

        walletDto.setId(id);
        return service.updateOne(walletDto);
    }
    @GetMapping("/walletByUser/{userId}")
    public WalletDto findByUser (@PathVariable Long userId ){
        return service.findByUser(userId);
    }
}
