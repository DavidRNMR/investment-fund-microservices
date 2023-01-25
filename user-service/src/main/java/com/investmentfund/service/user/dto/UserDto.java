package com.investmentfund.service.user.dto;

import com.investmentfund.service.user.models.Wallet;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {

    private Long id;
    private String name;
    private String email;
    private Wallet wallet;

}
