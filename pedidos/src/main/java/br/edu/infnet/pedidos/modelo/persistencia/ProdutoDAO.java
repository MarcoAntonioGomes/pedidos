package br.edu.infnet.pedidos.modelo.persistencia;

import br.edu.infnet.pedidos.entidades.Cliente;
import br.edu.infnet.pedidos.entidades.Produto;

import java.util.List;

public class ProdutoDAO extends JdbcDAO<Produto> {

    public ProdutoDAO() {
        super();
    }


    @Override
    public Boolean salvar(Produto obj) {
        return null;
    }

    @Override
    public List<Cliente> listarTodos() {
        return null;
    }

    @Override
    public Boolean atualizar(Produto obj) {
        return null;
    }

    @Override
    public Boolean excluir(Produto obj) {
        return null;
    }

    @Override
    public Cliente obter(Long codigo) {
        return null;
    }
}
