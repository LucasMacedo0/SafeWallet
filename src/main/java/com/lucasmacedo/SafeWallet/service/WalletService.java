package com.lucasmacedo.SafeWallet.service;

import com.lucasmacedo.SafeWallet.domain.DigitalWallet;
import com.lucasmacedo.SafeWallet.repository.UserRepository;
import com.lucasmacedo.SafeWallet.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class WalletService {
    @Autowired
    private WalletRepository repository;

    @Autowired
    private UserRepository userRepository;

    public void create(DigitalWallet digitalWallet) {
        digitalWallet.setUsuario(Optional.ofNullable(digitalWallet.getUsuario())
                .map(user -> userRepository.findByNome(digitalWallet.getUsuario().getNome()))
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado")));

        digitalWallet.setDataCriacao(LocalDateTime.now());
        repository.save(digitalWallet);
    }
}
