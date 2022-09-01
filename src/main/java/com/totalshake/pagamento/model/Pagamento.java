package com.totalshake.pagamento.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Min(0)
    private BigDecimal valor;
    @NotBlank
    @Max(100)
    private String nome;
    private String numero;
    private String expiracao;
    @NotBlank
    @Min(3)
    @Max(3)
    private String codigo;
    @NotNull
    private enumStatus status;
    private Long pedidoId;
    private enumFormadePagamento formaDePagamento;

    public Pagamento() {
    }

    public Pagamento(Long id, BigDecimal valor, String nome, String numero,
                     String expiracao, String codigo, enumStatus status, Long pedidoId,
                     enumFormadePagamento formaDePagamento) {
        this.id = id;
        this.valor = valor;
        this.nome = nome;
        this.numero = numero;
        this.expiracao = expiracao;
        this.codigo = codigo;
        this.status = status;
        this.pedidoId = pedidoId;
        this.formaDePagamento = formaDePagamento;
    }
}
