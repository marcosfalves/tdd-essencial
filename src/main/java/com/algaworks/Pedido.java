package com.algaworks;

public class Pedido {

    private double valortotal;
    private double desconto;

    public void adicionarItem(ItemPedido itemPedido) {
        valortotal = itemPedido.valorUnitario() * itemPedido.quantidade();
    }

    public double valorTotal() {
        return valortotal;
    }

    public double desconto() {
        return desconto;
    }
}
