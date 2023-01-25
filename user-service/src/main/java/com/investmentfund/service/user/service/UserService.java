package com.investmentfund.service.user.service;

import com.investmentfund.service.user.dto.UserDto;
import com.investmentfund.service.user.exceptions.UserNotFoundException;
import com.investmentfund.service.user.models.Wallet;


import java.util.List;

public interface UserService {

    UserDto saveUser (UserDto userDto);
    List<UserDto> findAllUsers();
    void delete(Long id);
    UserDto findOne(Long id) throws UserNotFoundException;
    UserDto updateUser (UserDto userDto);
    Wallet assignWallet (Wallet wallet, Long userId) throws UserNotFoundException;

}
