package com.lucasmacedo.SafeWallet.DTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String nome;
    private String email;
    private String senha;

}