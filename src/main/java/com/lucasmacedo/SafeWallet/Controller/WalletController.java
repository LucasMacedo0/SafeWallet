package com.lucasmacedo.SafeWallet.Controller;

import com.lucasmacedo.SafeWallet.domain.DigitalWallet;
import com.lucasmacedo.SafeWallet.service.WalletService;
import com.lucasmacedo.SafeWallet.validation.ValidationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/wallet")
public class WalletController {
    @Autowired
    private WalletService walletService;
    @Autowired
    private ValidationToken validationToken;

    @PostMapping("/create")
    public ResponseEntity<Map<String, String>> createWallet(@RequestBody DigitalWallet digitalWallet, @RequestHeader String authorization){

        validationToken.validate(authorization);
        walletService.create(digitalWallet);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Carteira criada com sucesso.");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
