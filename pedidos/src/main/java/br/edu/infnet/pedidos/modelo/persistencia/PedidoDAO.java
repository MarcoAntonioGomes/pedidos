package br.edu.infnet.pedidos.modelo.persistencia;

import br.edu.infnet.pedidos.entidades.Cliente;
import br.edu.infnet.pedidos.entidades.Pedido;
import br.edu.infnet.pedidos.entidades.Produto;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

public class PedidoDAO extends JdbcDAO<Pedido> {

    public PedidoDAO() {
        super();
    }


    @Override
    public Boolean salvar(Pedido obj) {
        return null;
    }

    @Override
    public List<Pedido> listarTodos() {
        String sql = "select p.codigo, p.data, c.nome, pr.descricao, pr.preco from pedido p\n" +
                "  join cliente c\n" +
                "  join itens_pedido i\n" +
                "  join produto pr\n" +
                "  on p.cliente_cod = c.codigo\n" +
                "  and p.codigo = i.pedido_cod\n" +
                " and pr.codigo = i.produto_cod;";

        Map<Long, Pedido> pedidos = new TreeMap<>();
        try{
            stm = con.createStatement();
            rs = stm.executeQuery(sql);

            while(rs.next()){
                Long codigo = rs.getLong("codigo");
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");
                Double preco = rs.getDouble("preco");
                LocalDate data = rs.getDate("data").toLocalDate();
                Pedido pedido = null;
                if(pedidos.get(codigo) == null) {
                    pedido = new Pedido(codigo, data, new Cliente(nome));
                    pedido.setProdutos(new ArrayList<>());
                    pedidos.put(codigo, pedido);
                }
                Produto produto = new Produto(null,descricao, preco);
                pedido = pedidos.get(codigo);
                pedido.getProdutos().add(produto);
            }

            return  new ArrayList<>(pedidos.values());
        } catch (Exception e){
            e.printStackTrace();
        }
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
    public Pedido obter(Long codigo) {
        return null;
    }
}
