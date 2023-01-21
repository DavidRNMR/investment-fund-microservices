package com.investmentfund.service.user.controller;

import com.investmentfund.service.user.dto.UserDto;
import com.investmentfund.service.user.exceptions.UserNotFoundException;
import com.investmentfund.service.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("/users")
    public List<UserDto> findUsers (){
        return service.findAllUsers();
    }

    @GetMapping("/users/{id}")
    public UserDto getOne (@PathVariable Long id) throws UserNotFoundException{
        return service.findOne(id);
    }

    @PostMapping("/users")
    public UserDto addOne (@RequestBody UserDto userDto){
        return service.saveUser(userDto);
    }

    @PutMapping("/users/{id}")
    public UserDto update (@RequestBody UserDto userDto, @PathVariable Long id){

        userDto.setId(id);
        return service.updateUser(userDto);
    }

    @DeleteMapping("/users/{id}")
    public void deleteOne (@PathVariable Long id){
        service.delete(id);
    }

    @GetMapping("/users/getWallet/{id}/{walletId}")
    public UserDto getUserWallet (@PathVariable Long id, @PathVariable Long walletId) throws  UserNotFoundException{

        return service.findUserWallet(id,walletId);
    }
}
