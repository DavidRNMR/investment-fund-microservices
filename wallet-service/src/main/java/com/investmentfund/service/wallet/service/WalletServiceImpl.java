package com.investmentfund.service.wallet.service;

import com.investmentfund.service.wallet.dto.UserDto;
import com.investmentfund.service.wallet.dto.WalletDto;
import com.investmentfund.service.wallet.entity.WalletEntity;
import com.investmentfund.service.wallet.enums.WalletStatus;
import com.investmentfund.service.wallet.exceptions.WalletNotFoundException;
import com.investmentfund.service.wallet.feign.UserClient;
import com.investmentfund.service.wallet.mapper.WalletMapper;
import com.investmentfund.service.wallet.repository.WalletRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class WalletServiceImpl implements WalletService{

    private WalletMapper mapper;
    private WalletRepository repository;
    private UserClient client;


    @Override
    public WalletDto saveWallet(WalletDto walletDto) {

        WalletEntity walletEntity = mapper.fromWalletDto(walletDto);
        WalletEntity saved = repository.save(walletEntity);

        if(saved.getBalance()>0){
            saved.setStatus(WalletStatus.POSTIVE);
        }else{
            saved.setStatus(WalletStatus.INTHERED);
        }
        return mapper.fromWallet(saved);
    }

    @Override
    public WalletDto findOne(Long id) throws WalletNotFoundException {

        WalletEntity walletEntity = repository.findById(id).orElseThrow(()->new WalletNotFoundException("wallet not found"));

        UserDto userDto = client.findUserById(walletEntity.getUserId());

        WalletDto walletDto = WalletDto.builder()
                .id(walletEntity.getId())
                .balance(walletEntity.getBalance())
                .userId(userDto.getId())
                .build();

        return walletDto;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<WalletDto> findAllWallets() {

        List<WalletEntity> walletEntities = repository.findAll();

        return walletEntities.stream().map(walletEntity -> mapper.fromWallet(walletEntity)).collect(Collectors.toList());
    }

    @Override
    public WalletDto updateOne(WalletDto walletDto) {

        WalletEntity walletEntity = mapper.fromWalletDto(walletDto);
        WalletEntity saved = repository.save(walletEntity);

        return mapper.fromWallet(saved);
    }

    @Override
    public WalletDto findByUser(Long userId) {

        WalletEntity walletEntity = repository.findByUserId(userId);

        return mapper.fromWallet(walletEntity);
    }

}
