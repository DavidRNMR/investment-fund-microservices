package com.investmentfund.service.user.repository;

import com.investmentfund.service.user.models.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {

    }
