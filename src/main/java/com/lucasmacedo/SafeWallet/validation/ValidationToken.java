package com.lucasmacedo.SafeWallet.validation;

import com.lucasmacedo.SafeWallet.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ValidationToken {
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public void validate(String authorizationHeader) {

        String token = authorizationHeader.replace("Bearer ", "");
        if (!jwtTokenProvider.validateToken(token)) {
            throw new RuntimeException("erro no token");
        }

        jwtTokenProvider.getEmailFromToken(token);

    }

}
