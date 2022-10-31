package br.edu.infnet.pedidos.entidades;

import java.time.LocalDate;
import java.util.List;

public class Pedido {

    private Long codigo;
    private LocalDate dataCriacao;
    private Cliente cliente;
    private List<Produto> produtos;

    public Pedido() {
    }

    public Pedido(Long codigo, LocalDate dataCriacao, Cliente cliente) {
        this.codigo = codigo;
        this.dataCriacao = dataCriacao;
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "codigo=" + codigo +
                ", dataCriacao=" + dataCriacao +
                ", cliente=" + cliente +
                ", produtos=" + produtos +
                '}';
    }
}
