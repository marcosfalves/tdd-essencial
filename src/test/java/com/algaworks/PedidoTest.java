package com.algaworks;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PedidoTest {

    private Pedido pedido;

    @Before
    public void setUp() throws Exception {
        pedido = new Pedido();
    }

    @Test
    public void devePermitirAdicionarUmItemNoPedido() {
        pedido.adicionarItem(new ItemPedido("Sabonete", 3.0, 10));
    }

    @Test
    public void deveCalcularValorTotalEDescontoParaPedidoVazio() {
        assertResumoPedido(0.0, 0.0);
    }

    @Test
    public void deveCalcularResumoParaUmItemSemDesconto() {
        pedido.adicionarItem(new ItemPedido("Sabonete", 5.0, 5));
        assertResumoPedido(25.0, 0.0);
    }

    private void assertResumoPedido(double valorTotal, double desconto) {
        assertEquals(valorTotal, pedido.valorTotal(), 0.0001);
        assertEquals(desconto, pedido.desconto(), 0.0001);
    }
}