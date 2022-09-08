package com.totalshake.pagamento.model;

import com.totalshake.pagamento.dto.PagamentoDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Positive
    private BigDecimal valor;
    @NotBlank
    @Size(max = 100)
    private String nome;
    private String numero;
    private String expiracao;
    @NotBlank
    @Size(min = 3, max = 3)
    private String codigo;
    @NotNull
    private EnumStatus status;
    @NotNull
    private Long pedidoId;
    private EnumFormadePagamento formaDePagamento;

    public Pagamento(Long id, BigDecimal valor, String nome, String numero,
                     String expiracao, String codigo, EnumStatus status, Long pedidoId,
                     EnumFormadePagamento formaDePagamento) {
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

    public PagamentoDto converterParaDto() {
        Long dtoId = this.getId();
        String dtoNome = this.getNome();
        EnumStatus enumStatus = this.getStatus();
        BigDecimal dtoValor = this.getValor();
        EnumFormadePagamento dtoEnumFormadePagamento = this.getFormaDePagamento();
        return new PagamentoDto(dtoId, dtoNome, enumStatus ,dtoValor, dtoEnumFormadePagamento);
    }

}
