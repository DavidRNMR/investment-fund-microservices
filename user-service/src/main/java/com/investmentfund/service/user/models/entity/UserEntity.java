package com.investmentfund.service.user.models.entity;


import com.investmentfund.service.user.models.Wallet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(unique = true)
    @Email
    private String email;

    @Transient
    private Wallet wallet;


}
