package com.algaworks;

import com.algaworks.desconto.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PedidoTest {

    private PedidoBuilder pedido;

    @Before
    public void setUp() throws Exception {
        pedido = new PedidoBuilder();
    }

    @Test
    public void deveCalcularValorTotalEDescontoParaPedidoVazio() {
        assertResumoPedido(0.0, 0.0);
    }

    @Test
    public void deveCalcularResumoParaUmItemSemDesconto() {
        pedido.comItem(5.0, 5);

        assertResumoPedido(25.0, 0.0);
    }

    @Test
    public void deveCalcularResumoParaDoisItensSemDesconto() {
        pedido.comItem(3.0, 3)
                .comItem(7.0,03);

        assertResumoPedido(30.00, 0.00);
    }

    @Test
    public void deveAplicarDescontoNaPrimeiraFaixa() {
        pedido.comItem(20.0, 20);

        assertResumoPedido(400.00, 16.00);
    }

    @Test
    public void deveAplicarDescontoNaSegundaFaixa() {
        pedido.comItem(15.0, 30)
                .comItem(15.0, 30);

        assertResumoPedido(900.00, 54.00);
    }
    @Test
    public void deveAplicarDescontoNaTerceiraFaixa() {
        pedido.comItem(15.0, 30)
                .comItem(15.0, 30)
                .comItem(10.0, 30);

        assertResumoPedido(1200.00, 96.00);
    }

    private void assertResumoPedido(double valorTotal, double desconto) {
        ResumoPedido resumoPedido = pedido.construir().resumo();
        assertEquals(new ResumoPedido(valorTotal, desconto), resumoPedido);
    }
}