package com.totalshake.pagamento.dto;

import com.totalshake.pagamento.model.Pagamento;
import com.totalshake.pagamento.model.EnumFormadePagamento;
import com.totalshake.pagamento.model.EnumStatus;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PagamentoDto {
    private Long id;
    private String nome;
    private BigDecimal valor;

    private EnumFormadePagamento enumFormadePagamento;

    public PagamentoDto(Long id, String nome, EnumStatus status, BigDecimal valor, EnumFormadePagamento enumFormadePagamento) {
        this.id = id;
        this.nome = nome;
        this.status = status;
        this.valor = valor;
        this.enumFormadePagamento = enumFormadePagamento;
    }
    private String numero;
    private String expiracao;

    private String codigo;
    private EnumStatus status;
    private Long pedidoId;
    private EnumFormadePagamento formaDePagamento;




    public Pagamento converterParaPagamento() {
        return new Pagamento(this.id, this.valor, this.nome, this.numero,
            this.expiracao, this.codigo, this.status, this.pedidoId, this.formaDePagamento
        );
    }
}
