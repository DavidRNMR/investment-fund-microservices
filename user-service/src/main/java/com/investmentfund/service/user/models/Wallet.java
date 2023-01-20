package com.investmentfund.service.user.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wallet {

    private Long id;
    private Float balance;
    private Long userId;

    public Wallet (Long userId){
        this.userId=userId;
    }
}
