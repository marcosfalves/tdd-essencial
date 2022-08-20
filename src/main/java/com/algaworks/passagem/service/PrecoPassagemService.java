package com.algaworks.passagem.service;

import com.algaworks.passagem.model.Passageiro;
import com.algaworks.passagem.model.TipoPassageiro;
import com.algaworks.passagem.model.Voo;

public class PrecoPassagemService {
    public double calcular(Passageiro passageiro, Voo voo) {
        return passageiro.tipo().getCalculadoraPrecoPassagem().calcular(voo);
    }
}
