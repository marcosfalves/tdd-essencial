package com.algaworks.pedidomock.service;

import com.algaworks.pedidomock.model.Pedido;
import com.algaworks.pedidomock.notificacao.NotificadorEmail;
import com.algaworks.pedidomock.notificacao.NotificadorSms;
import com.algaworks.pedidomock.repository.Pedidos;

import java.util.List;

public class PedidoService {
    private List<AcaoLancamentoPedido> acoes;

    public PedidoService(List<AcaoLancamentoPedido> acoes) {
        this.acoes = acoes;
    }

    public double lancar(Pedido pedido) {
        double imposto =  pedido.getValor() * 0.1;

        acoes.forEach(acao -> acao.executar(pedido));

        return imposto;
    }
}
