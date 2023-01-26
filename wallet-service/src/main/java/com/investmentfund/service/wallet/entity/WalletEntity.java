package com.investmentfund.service.wallet.entity;

import com.investmentfund.service.wallet.enums.WalletStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="wallets")
public class WalletEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float balance;

    @Enumerated(EnumType.STRING)
    private WalletStatus status;

    @Column(unique = true)
    private Long userId;
}
