package com.algaworks.passagem.service;

import com.algaworks.passagem.model.Passageiro;
import com.algaworks.passagem.model.TipoPassageiro;
import com.algaworks.passagem.model.Voo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrecoPassagemServiceTest {

    private PrecoPassagemService precoPassagemService;

    @Before
    public void setUp() throws Exception {
        precoPassagemService = new PrecoPassagemService();
    }

    @Test
    public void deveCalcularValorPassagemParaPassageiroGold_ComValorAbaixoDoLimite() {
        Passageiro passageiro = new Passageiro("João", TipoPassageiro.GOLD);
        Voo voo = new Voo("São Paulo", "Rio de janeiro", 100.00);
        assertValorPassagem(passageiro, voo, 90.00);
    }

    @Test
    public void deveCalcularValorPassagemParaPassageiroGold_ComValorAcimaDoLimite() {
        Passageiro passageiro = new Passageiro("João", TipoPassageiro.GOLD);
        Voo voo = new Voo("São Paulo", "Rio de janeiro", 600.00);
        assertValorPassagem(passageiro, voo, 510.00);
    }

    @Test
    public void deveCalcularValorPassagemParaPassageiroSilver_ComValorAbaixoDoLimite() {
        Passageiro passageiro = new Passageiro("João", TipoPassageiro.SILVER);
        Voo voo = new Voo("São Paulo", "Rio de janeiro", 100.00);
        assertValorPassagem(passageiro, voo, 94.00);
    }

    @Test
    public void deveCalcularValorPassagemParaPassageiroSilver_ComValorAcimaDoLimite() {
        Passageiro passageiro = new Passageiro("João", TipoPassageiro.SILVER);
        Voo voo = new Voo("São Paulo", "Rio de janeiro", 800.00);
        assertValorPassagem(passageiro, voo, 720.00);
    }

    private void assertValorPassagem(Passageiro passageiro, Voo voo, double esperado) {
        double valor = precoPassagemService.calcular(passageiro, voo);
        assertEquals(esperado, valor, 0.0001);
    }
}
