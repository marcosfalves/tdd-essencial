package com.algaworks.desconto;

public class CalculadoraDescontoPrimeiraFaixa extends CalculadoraFaixaDesconto {

    public CalculadoraDescontoPrimeiraFaixa(CalculadoraFaixaDesconto proximo) {
        super(proximo);
    }

    @Override
    protected double calcular(double valorTotal) {
        if (valorTotal > 300.00 && valorTotal <= 800.00)
            return valorTotal * 0.04;
        return -1;
    }
}
