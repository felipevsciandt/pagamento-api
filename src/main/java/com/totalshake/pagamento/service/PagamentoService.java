package com.totalshake.pagamento.service;

import com.totalshake.pagamento.config.PedidoConnection;
import com.totalshake.pagamento.dto.PagamentoDto;
import com.totalshake.pagamento.dto.PedidoDto;
import com.totalshake.pagamento.model.Pagamento;
import com.totalshake.pagamento.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService {

    @Autowired
    PagamentoRepository repository;

    @Autowired
    PedidoConnection connection;


    public List<Pagamento> findAll() {
        return repository.findAll();
    }

    public PagamentoDto getPagamentoById(Long id) {
        var payment = repository.findById(id).get();
        var dtoObject = payment.converterParaDto();
        return dtoObject;
    }

    public Pagamento criarPagamento(PagamentoDto pagamentoDto) {
        var pagamento = pagamentoDto.converterParaPagamento();
        PedidoDto pedidoDto = new PedidoDto(pagamentoDto.getPedidoId(), String.valueOf(pagamentoDto.getStatus()));
        connection.atualizaPagamentoPedido(pedidoDto);
        return repository.save(pagamento);
    }

    public void deletarPagamento(Long id) {
        var pagamentoDto = getPagamentoById(id);
        Pagamento pagamento = pagamentoDto.converterParaPagamento();
        repository.delete(pagamento);
    }


}
