package com.investmentfund.service.wallet.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {

    private Long id;
    private String name;
    private String email;
}
