package com.algaworks.passagem.service;

import com.algaworks.passagem.builders.VooBuilder;
import com.algaworks.passagem.model.Voo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrecoPassagemSilverTest {

    private CalculadoraPrecoPassagem calculadoraPrecoPassagem;
    private VooBuilder vooBuilder;

    @Before
    public void setUp() throws Exception {
        calculadoraPrecoPassagem = new PrecoPassagemSilver();
        vooBuilder = new VooBuilder();
    }

    @Test
    public void deveCalcularValorPassagemParaPassageiroSilver_ComValorAbaixoDoLimite() {
        Voo voo = vooBuilder.comOrigemDestino(100.00).build();

        double valor = calculadoraPrecoPassagem.calcular(voo);

        assertEquals(94.00, valor, 0.0001);
    }

    @Test
    public void deveCalcularValorPassagemParaPassageiroSilver_ComValorAcimaDoLimite() {
        Voo voo = vooBuilder.comOrigemDestino(800.00).build();

        double valor = calculadoraPrecoPassagem.calcular(voo);

        assertEquals(720.00, valor, 0.0001);
    }
}