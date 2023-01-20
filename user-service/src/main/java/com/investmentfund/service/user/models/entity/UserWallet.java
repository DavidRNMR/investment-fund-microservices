package com.investmentfund.service.user.models.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="users_wallets")
public class UserWallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="user_id",unique = true)
    private Long userId;
}
