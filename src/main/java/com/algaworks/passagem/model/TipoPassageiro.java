package com.algaworks.passagem.model;

import com.algaworks.passagem.service.CalculadoraPrecoPassagem;
import com.algaworks.passagem.service.PrecoPassagemGold;
import com.algaworks.passagem.service.PrecoPassagemSilver;

public enum TipoPassageiro {
    GOLD(new PrecoPassagemGold()),
    SILVER(new PrecoPassagemSilver());

    CalculadoraPrecoPassagem calculadoraPrecoPassagem;

    TipoPassageiro(CalculadoraPrecoPassagem calculadoraPrecoPassagem) {
        this.calculadoraPrecoPassagem = calculadoraPrecoPassagem;
    }

    public CalculadoraPrecoPassagem getCalculadoraPrecoPassagem() {
        return calculadoraPrecoPassagem;
    }
}
