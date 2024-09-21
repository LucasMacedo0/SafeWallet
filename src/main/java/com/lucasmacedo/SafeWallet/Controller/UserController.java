package com.lucasmacedo.SafeWallet.Controller;

import com.lucasmacedo.SafeWallet.domain.User;
import com.lucasmacedo.SafeWallet.security.LoginRequest;
import com.lucasmacedo.SafeWallet.service.UserService;
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
@RequestMapping("/usuarios")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<Map<String, String>> createUser(@RequestBody User user) {
        userService.createUser(user);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Usuário criado com sucesso.");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        var token = userService.loginUser(loginRequest);
        return ResponseEntity.ok(token);
    }

}
