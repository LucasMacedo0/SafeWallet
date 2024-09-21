package com.lucasmacedo.SafeWallet.repository;

import com.lucasmacedo.SafeWallet.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmailAndSenha(String email, String senha);
}
