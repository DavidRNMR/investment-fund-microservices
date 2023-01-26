package com.investmentfund.service.fund.controller;

import com.investmentfund.service.fund.dto.FundDto;
import com.investmentfund.service.fund.exceptions.FundNotFoundException;
import com.investmentfund.service.fund.service.FundService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class FundController {

    private FundService service;

    @GetMapping("/funds")
    public ResponseEntity<List<FundDto>> findFunds(){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping("funds/{id}")
    public ResponseEntity<FundDto> findOne (@PathVariable Long id) throws FundNotFoundException{
        return ResponseEntity.status(HttpStatus.OK).body(service.findOne(id));
    }

    @PostMapping("/funds")
    public ResponseEntity<FundDto> addOne (@RequestBody FundDto fundDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addOne(fundDto));
    }

    @PutMapping("/funds/{id}")
    public ResponseEntity<FundDto> updateFund (@RequestBody FundDto fundDto, @PathVariable Long id){
        fundDto.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(service.update(fundDto));
    }

    @DeleteMapping("/funds/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFund(@PathVariable Long id) throws FundNotFoundException{
       service.delete(id);
    }
}
