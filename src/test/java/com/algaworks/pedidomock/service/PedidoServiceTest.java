package com.algaworks.pedidomock.service;

import com.algaworks.pedidomock.model.Pedido;
import com.algaworks.pedidomock.model.builder.PedidoBuilder;
import com.algaworks.pedidomock.notificacao.NotificadorEmail;
import com.algaworks.pedidomock.notificacao.NotificadorSms;
import com.algaworks.pedidomock.repository.Pedidos;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

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
        pedidoService = new PedidoService(pedidos, notificadorEmail, notificadorSms);

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
        Mockito.verify(pedidos).guardar(pedido);
    }

    @Test
    public void deveNotificarPorEmail() {
        pedidoService.lancar(pedido);
        Mockito.verify(notificadorEmail).enviar(pedido);
    }

    @Test
    public void deveNotificarPorSms() {
        pedidoService.lancar(pedido);
        Mockito.verify(notificadorSms).notificar(pedido);
    }
}