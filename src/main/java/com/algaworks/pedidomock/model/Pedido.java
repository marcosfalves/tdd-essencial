package com.algaworks.pedidomock.model;

import java.util.Objects;

public class Pedido {

    private Cliente cliente;
    private double valor;

    private StatusPedido statusPedido;

    public Pedido() {
    }

    public Pedido(Cliente cliente, double valor, StatusPedido statusPedido) {
        this.cliente = cliente;
        this.valor = valor;
        this.statusPedido = statusPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Double.compare(pedido.valor, valor) == 0 && cliente.equals(pedido.cliente) && statusPedido == pedido.statusPedido;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cliente, valor, statusPedido);
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "cliente=" + cliente +
                ", valor=" + valor +
                ", statusPedido=" + statusPedido +
                '}';
    }
}
