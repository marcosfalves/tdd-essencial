package com.algaworks.pedido;

import com.algaworks.pedido.desconto.*;

public class PedidoBuilder {

    private Pedido instancia;

    public PedidoBuilder() {
        CalculadoraFaixaDesconto calculadoraDesconto =
                new CalculadoraDescontoTerceiraFaixa(
                        new CalculadoraDescontoSegundaFaixa(
                                new CalculadoraDescontoPrimeiraFaixa(
                                        new SemDesconto(null)
                                )
                        )
                );
        instancia = new Pedido(calculadoraDesconto);
    }

    public PedidoBuilder comItem(double valorUnitario, int quantidade){
        instancia.adicionarItem(new ItemPedido("Gerado", valorUnitario, quantidade));
        return this;
    }

    public Pedido construir() {
        return instancia;
    }
}
