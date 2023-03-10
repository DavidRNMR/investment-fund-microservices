package com.investmentfund.service.wallet.feign;

import com.investmentfund.service.wallet.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="user-service")
public interface UserClient {

    @GetMapping("/users/{id}")
    UserDto findUserById(@PathVariable Long id);
}
