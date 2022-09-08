package com.totalshake.pagamento.dto;

import com.totalshake.pagamento.model.EnumStatus;

public class PedidoDto {
    private Long id;
    private String status;

    public PedidoDto() {
    }

    public PedidoDto(Long id, String status) {
        this.id = id;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
