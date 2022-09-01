package com.totalshake.pagamento.service;

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

    public List<Pagamento> findAll() {
        return repository.findAll();
    }
}
