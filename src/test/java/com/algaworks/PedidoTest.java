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

    @Test
    public void deveCalcularResumoParaDoisItensSemDesconto() {
        pedido.adicionarItem(new ItemPedido("Sabonete", 3.0, 3));
        pedido.adicionarItem(new ItemPedido("Pasta dental", 7.0, 3));

        assertResumoPedido(30.00, 0.00);
    }

    @Test
    public void deveAplicarDescontoNaPrimeiraFaixa() {
        pedido.adicionarItem(new ItemPedido("Creme", 20.0, 20));

        assertResumoPedido(400.00, 16.00);
    }

    @Test
    public void deveAplicarDescontoNaSegundaFaixa() {
        pedido.adicionarItem(new ItemPedido("Shampoo", 15.0, 30));
        pedido.adicionarItem(new ItemPedido("Óleo", 15.0, 30));

        assertResumoPedido(900.00, 54.00);
    }
    @Test
    public void deveAplicarDescontoNaTerceiraFaixa() {
        pedido.adicionarItem(new ItemPedido("Creme", 15.0, 30));
        pedido.adicionarItem(new ItemPedido("Óleo", 15.0, 30));
        pedido.adicionarItem(new ItemPedido("Shampoo", 10.0, 30));


        assertResumoPedido(1200.00, 96.00);
    }

    private void assertResumoPedido(double valorTotal, double desconto) {
        ResumoPedido resumoPedido = pedido.resumo();
        assertEquals(valorTotal, resumoPedido.valorTotal(), 0.0001);
        assertEquals(desconto, resumoPedido.desconto(), 0.0001);
    }
}