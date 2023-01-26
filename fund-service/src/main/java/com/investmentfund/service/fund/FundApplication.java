package com.investmentfund.service.fund;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FundApplication {

    public static void main (String [] args){
        SpringApplication.run(FundApplication.class,args);
    }
}
