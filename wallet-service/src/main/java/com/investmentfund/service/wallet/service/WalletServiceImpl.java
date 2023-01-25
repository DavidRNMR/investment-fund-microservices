package com.investmentfund.service.wallet.service;

import com.investmentfund.service.wallet.dto.WalletDto;
import com.investmentfund.service.wallet.entity.WalletEntity;
import com.investmentfund.service.wallet.enums.WalletStatus;
import com.investmentfund.service.wallet.exceptions.WalletNotFoundException;
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

        return mapper.fromWallet(walletEntity);
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

    @Override
    public void transfer(Long id, Float amount) throws WalletNotFoundException {

        WalletEntity walletEntity = repository.findById(id).orElseThrow(()-> new WalletNotFoundException("wallet not found"));

        walletEntity.setBalance(walletEntity.getBalance()-amount);

        if(walletEntity.getBalance()<amount){

            walletEntity.setStatus(WalletStatus.INTHERED);
        }else{
            walletEntity.setStatus(WalletStatus.POSTIVE);
        }
    }
}
