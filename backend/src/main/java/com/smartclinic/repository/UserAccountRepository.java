package com.smartclinic.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartclinic.domain.Role;
import com.smartclinic.entity.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    Optional<UserAccount> findByEmailAndPasswordAndRole(String email, String password, Role role);
}