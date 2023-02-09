package com.investmentfund.service.user.service;

import com.investmentfund.service.user.dto.UserDto;
import com.investmentfund.service.user.exceptions.UserNotFoundException;

import java.util.List;

public interface UserService {

    UserDto saveUser (UserDto userDto);
    List<UserDto> findAllUsers();
    void delete(Long id);
    UserDto findOne(Long id) throws UserNotFoundException;
    UserDto updateUser (UserDto userDto);


}
