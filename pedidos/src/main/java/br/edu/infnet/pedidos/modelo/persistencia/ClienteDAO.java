package br.edu.infnet.pedidos.modelo.persistencia;

import br.edu.infnet.pedidos.entidades.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends JdbcDAO<Cliente>{

    public  ClienteDAO()  {
        super();
    }


    @Override
    public Boolean salvar(Cliente cliente){

        String sql = "INSERT INTO cliente (nome, codigo) VALUES (?, null )";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNome()); //avoid sql injection
            boolean execute = ps.executeUpdate() > 0;
            return execute;

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return false;
    }

    @Override
    public List<Cliente> listarTodos(){
      String sql = "SELECT * FROM cliente";
      List<Cliente> clientes = new ArrayList<>();
        try {
            stm = con.createStatement();
            rs = stm.executeQuery(sql);

            while(rs.next()){
                Cliente cliente = new Cliente(rs.getString("nome"), rs.getLong("codigo"));
                clientes.add(cliente);
            }

            return  clientes;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  clientes;
    }

    @Override
    public Boolean atualizar(Cliente cliente) {
        String sql = "UPDATE cliente SET nome = ? WHERE codigo = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNome()); //avoid sql injection
            ps.setLong(2, cliente.getCodigo());
            boolean execute = ps.executeUpdate() > 0;
            return execute;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Cliente obter(Long codigo){

        String sql = "SELECT * FROM cliente WHERE codigo = ?";
        Cliente cliente = null;
            try {
                ps = con.prepareStatement(sql);
                ps.setLong(1, codigo);
                rs = ps.executeQuery();

                while(rs.next()){
                    cliente = new Cliente(rs.getString("nome"), rs.getLong("codigo"));
                }

                return  cliente;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return  cliente;
    }

    @Override
    public Boolean excluir(Cliente cliente) {
        String sql = "DELETE FROM cliente WHERE codigo = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setLong(1, cliente.getCodigo());
            boolean execute = ps.executeUpdate() > 0;
            return execute;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
