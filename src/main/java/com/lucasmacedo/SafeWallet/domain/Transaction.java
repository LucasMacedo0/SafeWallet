package com.lucasmacedo.SafeWallet.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull(message = "Carteira é obrigatória")
    private Integer carteiraId;

    @NotNull(message = "Tipo de transação é obrigatório")
    private String tipo;

    @NotNull(message = "Valor é obrigatório")
    private BigDecimal valor;

    private LocalDateTime dataTransacao;
}
