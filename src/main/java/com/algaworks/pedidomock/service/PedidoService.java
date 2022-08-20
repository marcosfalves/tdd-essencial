package com.algaworks.pedidomock.service;

import com.algaworks.pedidomock.model.Pedido;
import com.algaworks.pedidomock.notificacao.NotificadorEmail;
import com.algaworks.pedidomock.notificacao.NotificadorSms;
import com.algaworks.pedidomock.repository.Pedidos;

public class PedidoService {

    private Pedidos pedidos;
    private NotificadorEmail notificadorEmail;
    private NotificadorSms notificadorSms;

    public PedidoService(Pedidos pedidos, NotificadorEmail notificadorEmail, NotificadorSms notificadorSms) {
        this.pedidos = pedidos;
        this.notificadorEmail = notificadorEmail;
        this.notificadorSms = notificadorSms;
    }

    public double lancar(Pedido pedido) {
        double imposto =  pedido.getValor() * 0.1;

        pedidos.guardar(pedido);
        notificadorEmail.enviar(pedido);
        notificadorSms.notificar(pedido);

        return imposto;
    }
}
