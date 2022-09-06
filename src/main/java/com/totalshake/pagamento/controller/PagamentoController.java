package com.totalshake.pagamento.controller;

import com.totalshake.pagamento.dto.PagamentoDto;
import com.totalshake.pagamento.model.Pagamento;
import com.totalshake.pagamento.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService service;

    @GetMapping
    public ResponseEntity<List<Pagamento>> findAll() {
        List<Pagamento> pagamentos = service.findAll();
        return ResponseEntity.ok().body(pagamentos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PagamentoDto> getPaymentById(@PathVariable Long id) {
        PagamentoDto pagamento = service.getPagamentoById(id);
        return ResponseEntity.ok().body(pagamento);
    }

    @PostMapping
    public ResponseEntity<Pagamento> cadastrarPagamento(@RequestBody PagamentoDto pagamentoDto) {
        Pagamento pagamento = service.cadastrarPagamento(pagamentoDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(pagamentoDto.getId()).toUri();
        return ResponseEntity.created(uri).body(pagamento);
    }
}
