package br.edu.infnet.pedidos.modelo.persistencia;

import br.edu.infnet.pedidos.entidades.Cliente;

import java.util.List;

public interface IDAO<T> {

    Boolean salvar(T obj);

    List<Cliente> listarTodos();

    Boolean atualizar(T obj);

    Boolean excluir(T obj);

    Cliente obter(Long codigo);
}
