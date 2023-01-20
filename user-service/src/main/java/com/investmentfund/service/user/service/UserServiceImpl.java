package com.investmentfund.service.user.service;

import com.investmentfund.service.user.dto.UserDto;
import com.investmentfund.service.user.exceptions.UserNotFoundException;
import com.investmentfund.service.user.mapper.UserMapper;
import com.investmentfund.service.user.models.entity.UserEntity;
import com.investmentfund.service.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private UserMapper mapper;
    private UserRepository repository;


    @Override
    public UserDto saveUser(UserDto userDto) {

        UserEntity userEntity = mapper.fromUserDto(userDto);
        UserEntity saved = repository.save(userEntity);

        return mapper.fromUser(saved);
    }

    @Override
    public List<UserDto> findAllUsers() {

        List<UserEntity> userEntities = repository.findAll();

        return userEntities.stream().map(user->mapper.fromUser(user)).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {

        repository.deleteById(id);
    }

    @Override
    public UserDto findOne(Long id) throws UserNotFoundException {

        UserEntity userEntity = repository.findById(id).orElseThrow(()-> new UserNotFoundException("user not found"));

        return mapper.fromUser(userEntity);
    }

    @Override
    public UserDto updateUser(UserDto userDto) {

        UserEntity userEntity = mapper.fromUserDto(userDto);
        UserEntity saved = repository.save(userEntity);

        return mapper.fromUser(saved);
    }
}
