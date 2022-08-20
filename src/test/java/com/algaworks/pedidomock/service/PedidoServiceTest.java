package com.algaworks.pedidomock.service;

import com.algaworks.pedidomock.model.Pedido;
import com.algaworks.pedidomock.model.StatusPedido;
import com.algaworks.pedidomock.model.builder.PedidoBuilder;
import com.algaworks.pedidomock.notificacao.NotificadorEmail;
import com.algaworks.pedidomock.notificacao.NotificadorSms;
import com.algaworks.pedidomock.repository.Pedidos;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PedidoServiceTest {

    private PedidoService pedidoService;
    @Mock
    private Pedidos pedidos;

    @Mock
    private NotificadorEmail notificadorEmail;

    private Pedido pedido;

    @Mock
    private NotificadorSms notificadorSms;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        pedidoService = new PedidoService(pedidos, List.of(pedidos, notificadorEmail, notificadorSms));

        pedido = new PedidoBuilder()
                .comValor(100.00)
                .para("João", "joao@joao.com.br", "9999-0000")
                .construir();
    }

    @Test
    public void deveCalcularOImposto() {
        double imposto = pedidoService.lancar(pedido);
        assertEquals(10.00, imposto, 0.0001);
    }

    @Test
    public void deveSalvarPedidoNoBancoDeDados() {
        pedidoService.lancar(pedido);
        verify(pedidos).executar(pedido);
    }

    @Test
    public void deveNotificarPorEmail() {
        pedidoService.lancar(pedido);
        verify(notificadorEmail).executar(pedido);
    }

    @Test
    public void deveNotificarPorSms() {
        pedidoService.lancar(pedido);
        verify(notificadorSms).executar(pedido);
    }

    @Test
    public void devePagarPedidoPendente() {
        Long codigoPedido = 135L;
        Pedido pedidoPendente = new Pedido();
        pedidoPendente.setStatusPedido(StatusPedido.PENDENTE);

        when(pedidos.buscarPeloCodigo(codigoPedido)).thenReturn(pedidoPendente);

        Pedido pedidoPago = pedidoService.pagar(codigoPedido);

        assertEquals(StatusPedido.PAGO, pedidoPago.getStatusPedido());
    }

    @Test(expected = StatusPedidoInvalidoException.class)
    public void deveNegarPagamento() {
        Long codigoPedido = 135L;
        Pedido pedidoPendente = new Pedido();
        pedidoPendente.setStatusPedido(StatusPedido.PAGO);

        when(pedidos.buscarPeloCodigo(codigoPedido)).thenReturn(pedidoPendente);

        pedidoService.pagar(codigoPedido);
    }
}