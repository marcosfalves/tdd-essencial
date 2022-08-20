package com.algaworks.pedido;

import com.algaworks.pedido.desconto.CalculadoraFaixaDesconto;
import com.algaworks.pedido.exception.QuantidadeItemNegativaException;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<ItemPedido> itens = new ArrayList<>();
    private final CalculadoraFaixaDesconto calculadoraDesconto;

    public Pedido(CalculadoraFaixaDesconto calculadoraDesconto) {
        this.calculadoraDesconto = calculadoraDesconto;
    }

    public void adicionarItem(ItemPedido itemPedido) {
        validarItemPedido(itemPedido);
        itens.add(itemPedido);
    }

    private void validarItemPedido(ItemPedido itemPedido) {
        if (itemPedido.quantidade() < 0)
                throw new QuantidadeItemNegativaException();
    }

    public ResumoPedido resumo(){
        double valorTotal = itens.stream().mapToDouble(i -> i.quantidade() * i.valorUnitario()).sum();
        double desconto = calculadoraDesconto.desconto(valorTotal);

        return new ResumoPedido(valorTotal, desconto);
    }
}
