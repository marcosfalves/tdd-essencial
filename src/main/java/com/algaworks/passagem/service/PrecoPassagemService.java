package com.algaworks.passagem.service;

import com.algaworks.passagem.model.Passageiro;
import com.algaworks.passagem.model.TipoPassageiro;
import com.algaworks.passagem.model.Voo;

public class PrecoPassagemService {
    public double calcular(Passageiro passageiro, Voo voo) {
        if (passageiro.tipo().equals(TipoPassageiro.GOLD)){
            if (voo.preco() > 500){
                return voo.preco() * 0.85;
            }
            return voo.preco() * 0.90;
        } else if (passageiro.tipo().equals(TipoPassageiro.SILVER)) {
            if (voo.preco() > 700){
                return voo.preco() * 0.90;
            }
            return voo.preco() * 0.94;
        }
        throw new TipoPassageiroInvalidoException();
    }
}
