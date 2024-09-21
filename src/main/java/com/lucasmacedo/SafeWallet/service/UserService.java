package com.lucasmacedo.SafeWallet.service;

import com.lucasmacedo.SafeWallet.security.LoginRequest;
import com.lucasmacedo.SafeWallet.domain.User;

import com.lucasmacedo.SafeWallet.repository.UserRepository;
import com.lucasmacedo.SafeWallet.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public void createUser(User userDTO) {
        userDTO.setDataCriacao(LocalDateTime.now());
        userRepository.save(userDTO);
    }

    public String loginUser(LoginRequest loginRequest) {
        User user = userRepository.findByEmailAndSenha(loginRequest.getEmail(), loginRequest.getSenha());

        if (user != null) {
            return jwtTokenProvider.createToken(user.getEmail());
        } else {
            throw new RuntimeException("Credenciais inválidas");
        }
    }

}
