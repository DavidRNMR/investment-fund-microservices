package com.investmentfund.service.user.mapper;

import com.investmentfund.service.user.dto.UserDto;
import com.investmentfund.service.user.models.entity.UserEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public UserDto fromUser (UserEntity userEntity){

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userEntity,userDto);

        return userDto;
    }

    public UserEntity fromUserDto (UserDto userDto){

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDto,userEntity);
        return userEntity;
    }

}
