package com.lucasmacedo.SafeWallet.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "usuario_id", "nomeCarteira" }) })
public class DigitalWallet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull(message = "Nome da Carteira é obrigatorio")
    private String nomeCarteira;

    @NotNull(message = "Numero da Carteira é obrigatorio")
    private String numeroCarteira;

    @NotNull(message = "Saldo é obrigatório")
    private BigDecimal saldo;

    private LocalDateTime dataCriacao;

    @NotNull(message = "Limite do saldo é obrigatorio")
    private BigDecimal limiteSaldo;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private User usuario;
}
