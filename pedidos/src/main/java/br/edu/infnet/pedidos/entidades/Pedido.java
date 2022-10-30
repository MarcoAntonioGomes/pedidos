package br.edu.infnet.pedidos.entidades;

import java.time.LocalDate;
import java.util.List;

public class Pedido {

    private Long codigo;
    private LocalDate dataCriacao;
    private Cliente cliente;
    private List<Produto> produtos;


}
