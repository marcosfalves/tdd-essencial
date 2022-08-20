package com.algaworks.passagem.service;

import com.algaworks.passagem.model.Voo;

public class PrecoPassagemGold implements CalculadoraPrecoPassagem {
    @Override
    public double calcular(Voo voo) {
        if (voo.preco() > 500)
            return calcularPrecoAcimaDoLimite(voo);
        return calcularPrecoAbaixoDoLimite(voo);
    }

    private double calcularPrecoAbaixoDoLimite(Voo voo) {
        return voo.preco() * 0.90;
    }

    private double calcularPrecoAcimaDoLimite(Voo voo) {
        return voo.preco() * 0.85;
    }
}
