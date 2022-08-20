package com.algaworks.passagem.service;

import com.algaworks.passagem.model.Voo;

public class PrecoPassagemSilver implements CalculadoraPrecoPassagem {
    @Override
    public double calcular(Voo voo) {
        if (voo.preco() > 700){
            return voo.preco() * 0.90;
        }
        return voo.preco() * 0.94;
    }
}
