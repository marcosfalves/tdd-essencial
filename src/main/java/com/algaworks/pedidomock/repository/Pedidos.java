package com.algaworks.pedidomock.repository;

import com.algaworks.pedidomock.model.Pedido;
import com.algaworks.pedidomock.service.AcaoLancamentoPedido;

public class Pedidos implements AcaoLancamentoPedido {
    @Override
    public void executar(Pedido pedido) {
        System.out.println("Salvando no banco de dados....");
    }

    public Pedido buscarPeloCodigo(Long codigo){
        //Ele iria no BD buscar o pedido pelo código
        return new Pedido();
    }
}
