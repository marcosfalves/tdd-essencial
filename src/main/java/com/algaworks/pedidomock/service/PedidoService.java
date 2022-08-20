package com.algaworks.pedidomock.service;

import com.algaworks.pedidomock.model.Pedido;
import com.algaworks.pedidomock.model.StatusPedido;
import com.algaworks.pedidomock.notificacao.NotificadorEmail;
import com.algaworks.pedidomock.notificacao.NotificadorSms;
import com.algaworks.pedidomock.repository.Pedidos;

import java.util.List;

public class PedidoService {
    private List<AcaoLancamentoPedido> acoes;

    private Pedidos pedidos;

    public PedidoService(Pedidos pedidos, List<AcaoLancamentoPedido> acoes) {
        this.acoes = acoes;
        this.pedidos = pedidos;
    }

    public double lancar(Pedido pedido) {
        double imposto =  pedido.getValor() * 0.1;

        acoes.forEach(acao -> acao.executar(pedido));

        return imposto;
    }

    public Pedido pagar(Long codigo) {
        Pedido pedido = pedidos.buscarPeloCodigo(codigo);

        if (!pedido.getStatusPedido().equals(StatusPedido.PENDENTE))
            throw new StatusPedidoInvalidoException();

        pedido.setStatusPedido(StatusPedido.PAGO);
        return pedido;
    }
}
