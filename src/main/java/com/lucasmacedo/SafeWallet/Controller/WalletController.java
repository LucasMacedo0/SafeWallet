package com.lucasmacedo.SafeWallet.Controller;

import com.lucasmacedo.SafeWallet.domain.DigitalWallet;
import com.lucasmacedo.SafeWallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/wallet")
public class WalletController {
    @Autowired
    private WalletService walletService;
    @PostMapping("/create")
    public ResponseEntity<Map<String, String>> createWallet(@RequestBody DigitalWallet digitalWallet){
        walletService.create(digitalWallet);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Carteira criada com sucesso.");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
