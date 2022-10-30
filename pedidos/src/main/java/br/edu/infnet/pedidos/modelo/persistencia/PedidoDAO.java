package br.edu.infnet.pedidos.modelo.persistencia;

import br.edu.infnet.pedidos.entidades.Cliente;
import br.edu.infnet.pedidos.entidades.Pedido;

import java.util.List;

public class PedidoDAO  extends JdbcDAO<Pedido> {

    public PedidoDAO() {
        super();
    }


    @Override
    public Boolean salvar(Pedido obj) {
        return null;
    }

    @Override
    public List<Cliente> listarTodos() {
        return null;
    }

    @Override
    public Boolean atualizar(Pedido obj) {
        return null;
    }

    @Override
    public Boolean excluir(Pedido obj) {
        return null;
    }

    @Override
    public Cliente obter(Long codigo) {
        return null;
    }
}
