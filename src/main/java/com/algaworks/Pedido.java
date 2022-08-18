package com.algaworks;

import com.algaworks.desconto.CalculadoraFaixaDesconto;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<ItemPedido> itens = new ArrayList<>();
    private final CalculadoraFaixaDesconto calculadoraDesconto;

    public Pedido(CalculadoraFaixaDesconto calculadoraDesconto) {
        this.calculadoraDesconto = calculadoraDesconto;
    }

    public void adicionarItem(ItemPedido itemPedido) {
        itens.add(itemPedido);
    }

    public ResumoPedido resumo(){
        double valorTotal = itens.stream().mapToDouble(i -> i.quantidade() * i.valorUnitario()).sum();
        double desconto = calculadoraDesconto.desconto(valorTotal);

        return new ResumoPedido(valorTotal, desconto);
    }
}
