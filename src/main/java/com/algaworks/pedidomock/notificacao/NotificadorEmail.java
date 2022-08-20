package com.algaworks.pedidomock.notificacao;

import com.algaworks.pedidomock.model.Pedido;
import com.algaworks.pedidomock.service.AcaoLancamentoPedido;

public class NotificadorEmail implements AcaoLancamentoPedido {
    @Override
    public void executar(Pedido pedido) {
        System.out.println("Enviando o e-mail....");
    }
}
