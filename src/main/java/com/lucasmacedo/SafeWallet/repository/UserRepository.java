package com.lucasmacedo.SafeWallet.repository;

import com.lucasmacedo.SafeWallet.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmailAndSenha(String email, String senha);
    User findByNome(String nome);
}
