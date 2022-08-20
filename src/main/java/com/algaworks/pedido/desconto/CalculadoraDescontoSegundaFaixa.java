package com.algaworks.pedido.desconto;

public class CalculadoraDescontoSegundaFaixa extends CalculadoraFaixaDesconto {

    public CalculadoraDescontoSegundaFaixa(CalculadoraFaixaDesconto proximo) {
        super(proximo);
    }

    @Override
    protected double calcular(double valorTotal) {
        if (valorTotal > 800.00 && valorTotal <= 1000.00)
            return valorTotal * 0.06;
        return -1;
    }
}
