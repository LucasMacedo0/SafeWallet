package com.lucasmacedo.SafeWallet.repository;

import com.lucasmacedo.SafeWallet.domain.DigitalWallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<DigitalWallet,Long> {
}
