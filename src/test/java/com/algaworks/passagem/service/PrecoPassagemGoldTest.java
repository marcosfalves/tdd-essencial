package com.algaworks.passagem.service;

import com.algaworks.passagem.builders.VooBuilder;
import com.algaworks.passagem.model.Voo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PrecoPassagemGoldTest {

    private CalculadoraPrecoPassagem calculadoraPrecoPassagem;
    private VooBuilder vooBuilder;

    @Before
    public void setUp() throws Exception {
        calculadoraPrecoPassagem = new PrecoPassagemGold();
        vooBuilder = new VooBuilder();
    }

    @Test
    public void deveCalcularValorPassagemParaPassageiroGold_ComValorAbaixoDoLimite() {
        Voo voo = vooBuilder.comOrigemDestino(100.00).build();

        double valor = calculadoraPrecoPassagem.calcular(voo);

        assertEquals(90.00, valor, 0.0001);
    }

    @Test
    public void deveCalcularValorPassagemParaPassageiroGold_ComValorAcimaDoLimite() {
        Voo voo = vooBuilder.comOrigemDestino(600.00).build();

        double valor = calculadoraPrecoPassagem.calcular(voo);

        assertEquals(510.00, valor, 0.0001);
    }
}