package com.totalshake.pagamento.config;

import com.totalshake.pagamento.dto.PagamentoDto;
import com.totalshake.pagamento.dto.PedidoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "pedidos", url = "http://localhost:8080/pedidos/pagar")
public interface PedidoConnection {

    @PostMapping
    public void atualizaPagamentoPedido(@RequestBody PedidoDto pedidoDto);
}
